package lesson3a;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Задача 5.
 * Дано натуральное число.
 * Найдите цифру, стоящую в разряде десятков в его десятичной записи (вторую справа цифру или 0, если число меньше 10).
 * Замечание Предполагается решение этой задачи без использования строковых методов. Пожалуйста, пользуйтесь арифметикой.
 * Формат ввода
 * Вводится единственное число.
 * Формат вывода
 * Выведите ответ на задачу.
 */
public class Task5 {

    public static void main(String[] args) {
        System.out.print("Введите натуральное число: ");
        BigInteger bigInteger = waitInputCorrectValue(new Scanner(System.in));
        int endTwoDigits = bigInteger.remainder(BigInteger.valueOf(100)).intValue();
        int tens = (endTwoDigits / 10) % 10;
        System.out.printf("Число %s содержит %d %s", bigInteger, tens, stringTens(tens));
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

    private static BigInteger waitInputCorrectValue(Scanner scanner) {
        BigInteger result;
        while (true) {
            if (scanner.hasNextBigInteger()) {
                result = scanner.nextBigInteger();
                if (isCorrectRange(result)) {
                    return result;
                }
                System.err.println("Значение должно быть больше нуля");
            } else {
                scanner.next();
                System.err.println("Значение должно быть целочисленным");
            }
        }
    }

    private static boolean isCorrectRange(BigInteger value) {
        int compare = value.compareTo(BigInteger.ZERO);
        return compare > 0;
    }
}
