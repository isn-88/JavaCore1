package lesson4;


import java.util.Scanner;

/**
 * Задание 1
 * Посчитать четные и нечетные цифры целого числа и вывести их на консоль.
 * Для решения написать 2 функции, которые будут принимать введенное целое число,
 * а возвращать количество четных цифр (вторая функция - нечетных).
 * Например: если введено число 228910, то у него 4 четные цифры (2, 2, 8, 0) и 2 нечетные (9, 1).
 */
public class Task1 {
    public static void main(String[] args) {
        System.out.print("Введите целое число: ");
        int value = waitInputCorrectValue(new Scanner(System.in));
        System.out.printf("Чётных цифр: %d\n", countEvenNumbers(value));
        System.out.printf("Нечётных цифр: %d\n", countOddNumbers(value));
    }

    private static int countEvenNumbers(int value) {
        int count = 0;
        while (value != 0) {
            int reminder = value % 10;
            if (isEven(reminder)) {
                count++;
            }
            value /= 10;
        }
        return count;
    }

    private static int countOddNumbers(int value) {
        int count = 0;
        while (value != 0) {
            int reminder = value % 10;
            if (!isEven(reminder)) {
                count++;
            }
            value /= 10;
        }
        return count;
    }

    private static boolean isEven(int value) {
        return value % 2 == 0;
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
