package lesson3a;


import java.util.Scanner;

/**
 * Задача 4.
 * Дано положительное двузначное число. Найдите число десятков в нем.
 * Формат ввода
 * Вводится единственное число (гарантируется, что оно соответствует условию задачи).
 * Формат вывода
 * Выведите ответ на задачу.
 */
public class Task4 {

    private static final int MIN = 10;
    private static final int MAX = 100;

    public static void main(String[] args) {
        System.out.print("Введите двухзначное число: ");
        int number = waitInputCorrectValue(new Scanner(System.in));
        int tens = (number / 10) % 10;
        System.out.printf("В числе %d содержится %d %s", number, tens, stringTens(tens));
    }

    private static String stringTens(int tens) {
        if (tens == 1) {
            return "десяток";
        } else if (2 <= tens && tens <= 4) {
            return "десятка";
        } else {
            return "десятков";
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
                System.err.printf("Значение должно быть от %d до %d\n", MIN, MAX);
            } else {
                scanner.next();
                System.err.println("Значение должно быть целочисленным");
            }
        }
    }

    private static boolean isCorrectRange(int value) {
        return MIN <= value && value < MAX;
    }
}


