package core.one.lesson3a;


import java.util.Scanner;

/**
 * Задача 8.
 * Дано целое число N. Выведите следующее за ним четное число.
 * Формат ввода
 * Вводится целое положительное число, не превышающее 1000.
 * Формат вывода
 * Выведите ответ на задачу.
 */
public class Task8 {

    private static final int MIN = 0;
    private static final int MAX = 1000;

    public static void main(String[] args) {
        System.out.printf("Введите положительное число до %d включительно: ", MAX);
        int value = waitInputCorrectValue(new Scanner(System.in));
        System.out.printf("Для числа %d следующее чётное число %d\n", value, ++value % 2 == 0 ? value : ++value);
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
