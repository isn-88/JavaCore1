package lesson4;


import java.util.Scanner;

/**
 * Задание 2
 * Дано целое число.
 * Написать функцию, которая принимает целое число, а возвращает целое число обратное этому (не строку!).
 * Результат вывести на консоль.
 * Например: 4508 -> 8054, 4700 -> 74, 1234567 -> 7654321
 * Примечание: для решения может понадобится функция возведение числа в степень: Math.pow(число, степень)
 */
public class Task2 {

    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        int value = waitInputCorrectValue(new Scanner(System.in));
        System.out.printf("Обратное значение  : %d", reverseInt(value));
    }

    private static int reverseInt(int value) {
        int result = 0;
        int position = lengthInt(value);
        while (position > 0) {
            result += powerPosition(value % 10, --position);
            value /= 10;
        }
        return result;
    }

    private static int lengthInt(int value) {
        int result = 0;
        do {
            result++;
            value /= 10;
        }
        while (value != 0);
        return result;
    }

    private static int powerPosition(int value, int pos) {
        int pow = 1;
        for (int i = 0; i < pos; i++) {
            pow *= 10;
        }
        return value * pow;
    }

    private static int waitInputCorrectValue(Scanner scanner) {
        while (true) {
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            } else {
                scanner.next();
                System.err.println("Значение должно быть целочисленным");
            }
        }
    }
}
