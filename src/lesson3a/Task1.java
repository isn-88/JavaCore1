package lesson3a;


import java.util.Scanner;

/**
 * Задача 1.
 * N школьников делят K яблок поровну, не делящийся остаток остается в корзинке.
 * Сколько яблок достанется каждому школьнику?
 * Формат ввода
 * Программа получает на вход числа N и K —  натуральные, не превышают 10000.
 * Формат вывода
 * Выведите ответ на задачу.
 */
public class Task1 {

    private static final int MIN = 1;
    private static final int MAX = 10000;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Школьников: ");
        int n = waitInputCorrectValue(scanner);
        System.out.print("Яблок: ");
        int k = waitInputCorrectValue(scanner);
        int count = k / n;
        System.out.printf("Каждому школьнику по %d %s", count, applesToString(count));
    }

    private static String applesToString(int count) {
        int units = count % 10;
        int tens = count % 100;
        if (units == 1 && tens != 11) {
            return "яблоку";
        } else if (2 <= units && units <= 4) {
            return "яблока";
        } else {
            return "яблок";
        }
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
