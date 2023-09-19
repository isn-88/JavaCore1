package core.one.lesson5;


import java.util.Arrays;

/**
 * Задача 2
 * Написать программу, удаляющую все повторяющиеся целые числа из массива и печатающую результат.
 * Массив должен использоваться тот же самый. На место удаленных элементов ставить цифру 0.
 */
public class Practice2 {

    public static void main(String[] args) {
        int[] array = {2, 0, 5, 4, 4, 2, 7, 5, 5, 1, 5};
        System.out.println(Arrays.toString(array));
        removeDuplicates(array);
        System.out.println(Arrays.toString(array));
    }

    private static void removeDuplicates(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if (array[i] != 0) {
                int searchValue = array[i];
                for (int j = i + 1; j < array.length; j++) {
                    if (array[j] == searchValue) {
                        array[j] = 0;
                    }
                }
            }
        }
    }
}
