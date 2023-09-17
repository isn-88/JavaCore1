package lesson5;


import java.util.Arrays;

/**
 * Задача 3
 * Заданы 2 массива целых чисел произвольной длины.
 * Написать программу, создающую третий массив, представляющий собой слияние 2-х заданных.
 * Пример:
 * 1-й массив: {1, 2, 3, 4, 5}
 * 2-й массив: {5, 6, 7}
 * Результат: {1, 5, 2, 6, 3, 7, 4, 5}

 */
public class Practice3 {

    public static void main(String[] args) {
        int[] array1 = {1, 2, 3, 4, 5};
        int[] array2 = {5, 6, 7};
        printArray(array1);
        printArray(array2);
        int[] result = union(array1, array2);
        printArray(result);
    }

    private static int[] union(int[] array1, int[] array2) {
        if (array1 == null && array2 == null) {
            return new int[0];
        } else if (array1 == null) {
            return array2;
        } else if (array2 == null) {
            return array1;
        } else {
            int[] union = new int[array1.length + array2.length];
            int unionIndex = 0;
            for (int i = 0; i < array1.length || i < array2.length; i++) {
                if (i < array1.length) {
                    union[unionIndex++] = array1[i];
                }
                if (i < array2.length) {
                    union[unionIndex++] = array2[i];
                }
            }
            return union;
        }
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
