package lesson5;

import java.util.Arrays;


/**
 * Задание 2
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел,
 * где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 */
public class Task2 {

    public static void main(String[] args) {
        char[] chars = {'a', '6', 'y', 'P', 'T', 'q', '9', '+' };
        printArray(chars);
        printArray(convertToIntArray(chars));
    }

    public static int[] convertToIntArray(char[] chars) {
        if (chars == null || chars.length == 0) {
            return new int[]{};
        }
        int[] result = new int[chars.length];
        for (int i = 0; i < chars.length; i++) {
            result[i] = chars[i];
        }
        return result;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    private static void printArray(char[] array) {
        System.out.println(Arrays.toString(array));
    }
}
