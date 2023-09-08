package lesson3a;


import java.util.Scanner;

/**
 * Задача 7.
 * Электронные часы показывают время в формате h:mm:ss,
 * то есть сначала записывается количество часов (число от 0 до 23),
 * потом обязательно двузначное количество минут, затем обязательно двузначное количество секунд.
 * Количество минут и секунд при необходимости дополняются до двузначного числа нулями.
 * С начала суток прошло N секунд. Выведите, что покажут часы.
 * Формат ввода
 * Вводится число N — целое, неотрицательное.
 * Формат вывода
 * Выведите показания часов, соблюдая формат.
 * Примечания
 * Вывести числа можно поциферно. Входные данные: 3602 Вывод программы: 1:00:02
 */
public class Task7 {

    private static final int MIN = 0;
    private static final int MAX = 86400;

    public static void main(String[] args) {
        System.out.print("Введите количество секунд: ");
        int value = waitInputCorrectValue(new Scanner(System.in));
        int hour = value / 3600;
        value %= 3600;
        int minutes = value / 60;
        int seconds = value % 60;
        System.out.printf("%d:%02d:%02d", hour, minutes, seconds);
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
