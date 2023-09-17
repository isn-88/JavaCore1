package lesson5;

import java.util.Arrays;


/**
 * Задание 3
 * Дан одномерный массив целых чисел.
 * Написать функцию, которая принимает этот массив и разбивает на 3 других:
 * с только отрицательными числами, только положительными и только нули.
 * Если для какого-то из массивов не будет значений, то должен быть создан пустой массив.
 * Возвращает функция эти три массива в виде одного двумерного.
 * Пример:
 *                          |-> [-4, -18]
 * [-4, 0, 1, 9, 0, -18, 3] |-> [0, 0]
 *                          |-> [1, 9, 3]
 */
public class Task3 {

    private static final int POSITIVE = 1;
    private static final int ZERO = 0;
    private static final int NEGATIVE = -1;


    public static void main(String[] args) {

        System.out.println("Check null");
        int[] valuesNull = null;
        printArray(valuesNull);
        printArray(splitArray(valuesNull));

        System.out.println("\nCheck empty");
        int[] valuesEmpty = {};
        printArray(valuesEmpty);
        printArray(splitArray(valuesEmpty));

        System.out.println("\nCheck mixed");
        int[] valuesMixed = {-4, 0, 1, 9, 0, -18, 3};
        printArray(valuesMixed);
        printArray(splitArray(valuesMixed));

        System.out.println("\nCheck only positive");
        int[] valuesPos = {4, 10, 1, 9, 10, 18, 3};
        printArray(valuesPos);
        printArray(splitArray(valuesPos));

        System.out.println("\nCheck only zero");
        int[] valuesZero = {0, 0, 0, 0, 0, 0, 0};
        printArray(valuesZero);
        printArray(splitArray(valuesZero));

        System.out.println("\nCheck only negative");
        int[] valuesNeg = {-4, -10, -1, -9, -10, -18, -3};
        printArray(valuesNeg);
        printArray(splitArray(valuesNeg));
    }

    private static int[][] splitArray(int[] values) {
        int[][] result = new int[3][];
        result[0] = getOnly(NEGATIVE, values);
        result[1] = getOnly(ZERO, values);
        result[2] = getOnly(POSITIVE, values);
        return result;
    }

    private static int[] getOnly(int type, int[] values) {
        if (values == null || values.length == 0) {
            return new int[]{};
        }
        int countValues = countValues(type, values);
        if (countValues > 0) {
            int[] newArray = new int[countValues];
            int index = 0;
            for (int value : values) {
                if (condition(type, value)) {
                    newArray[index++] = value;
                }
            }
            return newArray;
        }
        return new int[]{};
    }

    private static int countValues(int type, int[] values) {
        int count = 0;
        if (values != null) {
            for (int value : values) {
                if (condition(type, value)) {
                    count++;
                }
            }
        }
        return count;
    }

    private static boolean condition(int type, int value) {
        return switch (type) {
            case POSITIVE -> value > 0;
            case ZERO -> value == 0;
            case NEGATIVE -> value < 0;
            default -> throw new IllegalStateException("Unexpected value: " + type);
        };
    }

    private static void printArray(int[][] arrays) {
        for (int[] array : arrays) {
            printArray(array);
        }
    }

    private static void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }
}
