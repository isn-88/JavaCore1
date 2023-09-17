package lesson5;

import java.util.Arrays;


/**
 * Задание 1
 * Дан одномерный массив целых чисел.
 * Написать функцию, удаляющую из него все отрицательные элементы
 * (удалить - значит создать новый массив с только положительными элементами).
 * После удаления - умножить каждый элемент массива на его длину.
 * Например: [3, 5, -6, 3, 2, -9, 0, -123] -> [15, 25, 15, 10, 0]
 */
public class Task1 {

    public static void main(String[] args) {

        System.out.println("Test null");
        int[] testNull = null;
        printArray(testNull);
        printArray(multipleByLength(deleteNegativeValues(testNull)));

        System.out.println("\nTest empty");
        int[] testEmpty = new int[]{};
        printArray(testEmpty);
        printArray(multipleByLength(deleteNegativeValues(testEmpty)));

        System.out.println("\nTest only negative");
        int[] testOnlyNegative = new int[]{-6, -9};
        printArray(testOnlyNegative);
        printArray(multipleByLength(deleteNegativeValues(testOnlyNegative)));

        System.out.println("\nTest mixed");
        int[] testValues = {3, 5, -6, 3, 2, -9, 0, -123};
        printArray(testValues);
        printArray(multipleByLength(deleteNegativeValues(testValues)));

        System.out.println("\nTest positive");
        int[] testPositive = {3, 5, 6, 3, 2, 9, 0, 123};
        printArray(testPositive);
        printArray(multipleByLength(deleteNegativeValues(testPositive)));
    }

    private static int[] deleteNegativeValues(int[] values) {
        if (values == null || values.length == 0) {
            return new int[]{};
        }
        int countNegativeValues = countNegativeValues(values);
        if (countNegativeValues > 0) {
            int[] positiveArray = new int[values.length - countNegativeValues];
            if (positiveArray.length > 0) {
                int index = 0;
                for (int value : values) {
                    if (value >= 0) {
                        positiveArray[index++] = value;
                    }
                }
            }
            return positiveArray;
        }
        return values;
    }

    private static int[] multipleByLength(int[] values) {
        if (values == null) {
            return new int[]{};
        }
        for (int i = 0; i < values.length; i++) {
            values[i] *= values.length;
        }
        return values;
    }

    private static int countNegativeValues(int[] values) {
        int count = 0;
        if (values != null) {
            for (int value : values) {
                if (value < 0) count++;
            }
        }
        return count;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
