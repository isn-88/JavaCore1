package core.one.lesson3a;


import java.util.Scanner;

/**
 * Задача 3.
 * Дано натуральное число. Выведите его последнюю цифру.
 * Формат ввода
 * Вводится единственное целое положительное число (гарантируется, что оно не превышает 10000).
 * Формат вывода
 * Выведите ответ на задачу.
 */
public class Task3 {

    private static final int MIN = 1;
    private static final int MAX = 10000;

    public static void main(String[] args) {
        System.out.print("Введите натуральное число: ");
        int number = waitInputCorrectValue(new Scanner(System.in));
        System.out.printf("Последняя цифра числа %d равна %d", number, number % 10);
    }

    private static int waitInputCorrectValue(Scanner scanner) {
        int result;
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (isCorrectRange(result)) {
                    return result;
                }
                System.err.printf("Значение должно быть от %d до %d включительно\n", MIN, MAX);
            } else {
                scanner.next();
                System.err.println("Значение должно быть целочисленным");
            }
        }
    }

    private static boolean isCorrectRange(int value) {
        return MIN <= value && value <= MAX;
    }
}
