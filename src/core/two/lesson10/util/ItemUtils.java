package core.two.lesson10.util;

import static java.nio.file.StandardOpenOption.*;
import static java.util.stream.Collectors.toMap;

import core.two.lesson10.model.Item;
import core.two.lesson10.model.Price;
import core.two.lesson10.model.Name;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;

public final class ItemUtils {

  private ItemUtils() {
  }

  /**
   * Считывает данные с ценами из файла и возвращает Map, где ключом является id,
   * а значением объекты Price
   */
  public static Map<Integer, Price> priceFromFile(Path path) {
    try {
      return Files.readAllLines(path).stream()
          .skip(1)
          .map(Price::new)
          .collect(toMap(Price::getId, Function.identity()));
    } catch (IOException e) {
      System.err.printf("Can't not read file \n%s", e.getMessage());
      return new HashMap<>();
    }
  }

  /**
   * Считывает данные с товарами из файла и возвращает Map, где ключом является id,
   * а значением объекты Name
   */
  public static Map<Integer, Name> nameFromFile(Path path) {
    try {
      return Files.readAllLines(path).stream()
          .skip(1)
          .map(Name::new)
          .collect(toMap(Name::getId, Function.identity()));
    } catch (IOException e) {
      System.err.printf("Can't not read file \n%s", e.getMessage());
      return new HashMap<>();
    }
  }

  /**
   * Объединяет Price и Name с одинаковыми идентификаторами,
   * создавая на их основе новые объекты Item
   */
  public static Map<Integer, Item> join(Map<Integer, Price> priceMap,
                                        Map<Integer, Name> nameMap) {
    return findIntersectIds(priceMap.keySet(), nameMap.keySet()).stream()
        .map(id -> new Item(id, nameMap.get(id).getName(), priceMap.get(id).getPrice()))
        .collect(Collectors.toMap(Item::getId, Function.identity()));
  }

  /**
   * Возвращает только совпадающие значения в множествах
   */
  public static Set<Integer> findIntersectIds(Set<Integer> first, Set<Integer> second) {
    Set<Integer> result = new TreeSet<>(first);
    result.retainAll(second);
    return result;
  }

  /**
   * Возвращает только различающиеся значения в множествах
   */
  public static Set<Integer> findMinusIds(Set<Integer> first, Set<Integer> second) {
    Set<Integer> result = new TreeSet<>(first);
    result.addAll(second);
    result.removeAll(findIntersectIds(first, second));
    return result;
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
   * Сохраняет все одиночные идентификаторы в файл csv
   */
  public static void saveSingleIdsToFile(Path path, Set<Integer> ids) {
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
