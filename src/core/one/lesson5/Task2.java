package core.one.lesson5;


import java.util.Arrays;

/**
 * Задание 2
 * Дан одномерный массив символов.
 * Преобразовать его в одномерный массив чисел,
 * где число - это код символа (любой символ - это число в памяти компьютера).
 * Например: [‘a’, ‘6’, ‘y’, ‘P’, ‘T’, ‘q’, ‘9’, ‘+’] -> [97, 54, 121, 80, 84, 113, 57, 43]
 * Далее определить среднее арифметическое всех элементов целочисленного массива
 * и вывести на консоль только те элементы, которые больше этого среднего арифметического.
 */
public class Task2 {

    public static void main(String[] args) {
        char[] chars = {'a', '6', 'y', 'P', 'T', 'q', '9', '+' };
        int[] intArray = convertToIntArray(chars);
        System.out.print("Исходный массив: ");
        printArray(intArray);
        double averageValue = getAverageValue(intArray);
        System.out.printf("Среднее арифметическое: %.2f\n", averageValue);
        System.out.print("Результирующий массив: ");
        printMoreThanAverage(intArray, averageValue);
    }

    private static double getAverageValue(int[] intArray) {
        if (intArray != null && intArray.length > 0) {
            int sum = 0;
            for (int value : intArray) {
                sum += value;
            }
            return (double) sum / intArray.length;
        }
        return 0;
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

    private static void printMoreThanAverage(int[] array, double averageValue) {
        if (array == null || array.length == 0) {
            System.err.println("Исходный массив пустой");
            return;
        }
        int[] moreValues = new int[getMoreValuesCount(array, averageValue)];
        int index = 0;
        for (int value : array) {
            if (value > averageValue) {
                moreValues[index++] = value;
            }
        }
        printArray(moreValues);
    }

    private static int getMoreValuesCount(int[] array, double averageValue) {
        if (array == null) {
            return 0;
        }
        int count = 0;
        for (int value : array) {
            if (value > averageValue) {
                count++;
            }
        }
        return count;
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
