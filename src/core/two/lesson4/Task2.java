package core.two.lesson4;


import java.util.Arrays;

/**
 * Задание 2
 * Дана строка с текстом, в котором есть цифры от 0 до 9.
 * Написать 2 метода:
 * - возвращающий массив цифр из переданной строки
 * - возвращающий сумму цифр из переданного целочисленного массива
 * Посчитать сумму всех чисел из строки
 * Например:
 * “Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?” -> 18 (8+1+2+4+3)
 */
public class Task2 {

    public static void main(String[] args) {
        String text = "Привет 8, как 1 2 твои дела? Может4, сделать 3 дело?";
        System.out.printf("Исходная строка: %s\n", text);
        int[] digits = getDigitsArrayFromString(text);
        System.out.printf("Массив цифр: %s\n", Arrays.toString(digits));
        System.out.printf("Сумма цифр: %d\n", countSumArray(digits));
    }

    private static int[] getDigitsArrayFromString(String text) {
        if (text == null || text.isEmpty()) {
            return new int[0];
        }
        StringBuilder builder = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isDigit(c)) {
                builder.append(c);
            }
        }
        if (builder.length() > 0) {
            int[] result = new int[builder.length()];
            for (int i = 0; i < builder.length(); i++) {
                result[i] = Integer.parseInt(String.valueOf(builder.charAt(i)));
            }
            return result;
        }
        return new int[0];
    }

    private static int countSumArray(int[] digits) {
        if (digits == null) {
            return 0;
        }
        int result = 0;
        for (int digit : digits) {
            result += digit;
        }
        return result;
    }
}

