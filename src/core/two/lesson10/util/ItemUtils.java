package core.two.lesson10.util;

import static java.nio.file.StandardOpenOption.*;
import static java.util.stream.Collectors.toMap;
import static java.util.stream.Collectors.toSet;

import core.two.lesson10.model.Item;
import core.two.lesson10.model.Price;
import core.two.lesson10.model.Name;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public final class ItemUtils {

  private ItemUtils() {
  }

  /**
   * Считывает данные с ценами из файла и возвращает Map, где ключом является id, а значением
   * объекты Item
   */
  public static Map<Integer, Item> priceFromFile(Path path) {
    try {
      return Files.readAllLines(path).stream()
          .skip(1)
          .map(Price::new)
          .map(Item::new)
          .collect(toMap(Item::getId, Function.identity()));
    } catch (IOException e) {
      System.err.printf("Can't not read file \n%s", e.getMessage());
      return new HashMap<>();
    }
  }

  /**
   * Считывает данные с товарами из файла и возвращает Map, где ключом является id, а значением
   * объекты Item
   */
  public static Map<Integer, Item> nameFromFile(Path path) {
    try {
      return Files.readAllLines(path).stream()
          .skip(1)
          .map(Name::new)
          .map(Item::new)
          .collect(toMap(Item::getId, Function.identity()));
    } catch (IOException e) {
      System.err.printf("Can't not read file \n%s", e.getMessage());
      return new HashMap<>();
    }
  }

  /**
   * Объединяет различные данные из объектов Item с одинаковыми идентификаторами
   */
  public static Map<Integer, Item> union(Map<Integer, Item> firstMap,
                                         Map<Integer, Item> secondMap) {
    if (firstMap == null || secondMap == null) {
      if (firstMap != null) {
        return firstMap;
      } else if (secondMap != null) {
        return secondMap;
      } else {
        return new HashMap<>();
      }
    }
    return Stream.of(firstMap, secondMap)
        .flatMap(map -> map.entrySet().stream())
        .collect(toMap(Entry::getKey, Entry::getValue, Item::merge));
  }

  /**
   * Возвращает множество свободных идентификаторов
   */
  public static Set<Integer> getEmptyIds(Map<Integer, Item> items) {
    if (items == null) {
      return new HashSet<>();
    }
    Set<Integer> keyItems = items.keySet();
    OptionalInt maxOpt = keyItems.stream()
        .mapToInt(k -> k)
        .max();
    if (maxOpt.isPresent()) {
      Set<Integer> result = IntStream.range(1, maxOpt.getAsInt())
          .boxed()
          .collect(toSet());
      result.removeAll(keyItems);
      return result;
    }
    return new HashSet<>();
  }

  /**
   * Сохраняет все позиции (Item) в файл csv
   */
  public static void saveItemsToFile(Path path, Map<Integer, Item> itemMap) {
    List<String> lines;
    if (itemMap != null) {
      lines = itemMap.values().stream()
          .sorted()
          .map(Item::toCsv)
          .toList();
    } else {
      lines = new ArrayList<>();
    }
    try {
      Files.writeString(path, "ID,NAME,PRICE");
      Files.writeString(path, System.lineSeparator(), APPEND);
      Files.write(path, lines, APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Сохраняет все свободные идентификаторы в файл csv
   */
  public static void saveEmptyIdsToFile(Path path, Set<Integer> ids) {
    List<String> sIds;
    if (ids != null) {
      sIds = ids.stream()
          .map(String::valueOf)
          .collect(Collectors.toList());
    } else {
      sIds = new ArrayList<>();
    }
    try {
      Files.writeString(path, "ID");
      Files.writeString(path, System.lineSeparator(), APPEND);
      Files.write(path, sIds, APPEND);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
