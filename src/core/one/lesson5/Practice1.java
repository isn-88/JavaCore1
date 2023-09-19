package core.one.lesson5;


import java.util.Arrays;

/**
 * Напишите программу, которая циклически сдвигает элементы массива вправо на одну позицию,
 * и печатает результат. Цикличность означает, что последний элемент массива становится самым первым его элементом.
 */
public class Practice1 {

    public static void main(String[] args) {
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0};
        printArray(values);
        shiftRight(values);
        printArray(values);
        shiftRight(values);
        printArray(values);
        shiftRight(values);
        printArray(values);
    }

    private static void shiftRight(int[] values) {
        if (values == null || values.length == 0) {
            return;
        }
        int endValue = values[values.length - 1];
        for (int i = values.length - 1; i > 0; i--) {
            values[i] = values[i - 1];
        }
        values[0] = endValue;
    }

    private static void printArray(int[] values) {
        System.out.println(Arrays.toString(values));
    }
}
