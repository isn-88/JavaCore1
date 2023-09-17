package lesson5;


import java.util.Arrays;

/**
 * Задача 4
 * Написать функцию linearize, которая принимает в качестве параметра двумерный массив
 * и возвращает одномерный массив со всеми элементами двумерного.
 */
public class Practice4 {

    public static void main(String[] args) {
        int[][] arrays = {
                {1, 2, 3},
                {4},
                null,
                {5, 6, 7},
                {},
                null,
                {8, 9}
        };

        printArray(linearize(arrays));
    }

    private static int[] linearize(int[][] arrays) {
        if (arrays == null) {
            return new int[0];
        }
        int totalLength = getTotalLength(arrays);
        if (totalLength == 0) {
            return new int[0];
        }
        int index = 0;
        int[] result = new int[totalLength];
        for (int[] array : arrays) {
            if (array != null) {
                for (int item : array) {
                    result[index++] = item;
                }
            }
        }
        return result;
    }

    private static int getTotalLength(int[][] arrays) {
        if (arrays == null) {
            return 0;
        }
        int totalLength = 0;
        for (int[] array : arrays) {
            if (array != null) {
                totalLength += array.length;
            }
        }
        return totalLength;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
