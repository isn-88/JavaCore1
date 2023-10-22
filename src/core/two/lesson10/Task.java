package core.two.lesson10;

import core.two.lesson10.model.Item;
import core.two.lesson10.util.ItemUtils;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Map;

/**
 * Задание 1
 * Даны два файла в формате CSV.
 * CSV (Comma-Separated Values) файл - это обычный текстовый файл, где через запятую
 * (может использоваться и любой другой символ) перечислены значения.
 * Также может быть в первой строчке таких файлов заголовок с названием колонок.
 * ---
 * Формат первого файла items-price.csv:
 * ID,PRICE
 * 1,9.98
 * 2,25.05
 * 3,16.45
 * ---
 * Формат второго файла items-name.csv:
 * ID,NAME,DESCRIPTION
 * 1,Шарф,Теплый зимний шарф красного цвета
 * 2,Шапка,Вязаная зеленая шапка
 * 3,Ботинки,Осенние ботинки на толстой подошве
 * ---
 * Задача:
 * Считать оба CSV файла и объединить их по полю ID в один result.csv,
 * где будут следующие поля: ID,NAME,PRICE.
 * Желательно реализовать доп. функционал:
 * Если для каких-то ID не будет значений в обоих файлах,
 * то записать их в один файл errors.csv, где будет лишь одно поле ID.
 */
public class Task {

  public static void main(String[] args) throws IOException {
    Path filePrice = Path.of("src", "resources", "lesson10", "items-price.csv");
    Path fileName = Path.of("src", "resources", "lesson10", "items-name.csv");

    // read data and union to result
    Map<Integer, Item> priceItems = ItemUtils.priceFromFile(filePrice);
    Map<Integer, Item> nameItems = ItemUtils.nameFromFile(fileName);
    Map<Integer, Item> result = ItemUtils.union(priceItems, nameItems);

    // write to result.csv
    Path fileResult = Path.of("src", "resources", "lesson10", "result.csv");
    ItemUtils.saveItemsToFile(fileResult, result);

    // write to error.csv
    Path fileError = Path.of("src", "resources", "lesson10", "errors.csv");
    ItemUtils.saveEmptyIdsToFile(fileError, ItemUtils.getEmptyIds(result));
  }

}
