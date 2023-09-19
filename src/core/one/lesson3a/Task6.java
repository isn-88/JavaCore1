package core.one.lesson3a;


/**
 * Задача 6.
 * Дано трехзначное число. Найдите сумму его цифр.
 * Формат ввода
 * Вводится целое положительное число. Гарантируется, что оно соответствует условию задачи.
 * Формат вывода
 * Выведите ответ на задачу.
 */
public class Task6 {

    public static void main(String[] args) {
        int value = 333;
        System.out.printf("Сумма цифр числа %d равна %d", value, sumDigits(value));
    }

    private static int sumDigits(int value) {
        int result = 0;
        while (value > 0) {
            result += value % 10;
            value /= 10;
        }
        return result;
    }
}
