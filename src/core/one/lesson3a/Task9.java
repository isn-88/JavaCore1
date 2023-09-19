package core.one.lesson3a;


import java.util.Scanner;

/**
 * Задача 9.
 * Длина Московской кольцевой автомобильной дороги —  109 километров.
 * Байкер Вася стартует с нулевого километра МКАД и едет со скоростью v километров в час.
 * На какой отметке он остановится через t часов?
 * Формат ввода
 * Программа получает на вход значение v и t.
 * Если v>0, то Вася движется в положительном направлении по МКАД, если же значение v<0, то в отрицательном.
 * (Гарантируется, что исходные числа — целые и находятся в промежутке от -1000 до +1000).
 * Формат вывода
 * Программа должна вывести целое число от 0 до 108 — номер отметки, на которой остановится Вася.
 */
public class Task9 {

    private static final int ROAD_LENGTH = 109;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите скорость: ");
        int speed = waitInputCorrectValue(scanner, -1000, 1000);
        System.out.print("Введите время: ");
        int time = waitInputCorrectValue(scanner, 0, 24);
        int result = speed * time % ROAD_LENGTH;
        result = (result < 0) ? ROAD_LENGTH + result : result;
        System.out.println(result);
    }

    private static int waitInputCorrectValue(Scanner scanner, int min, int max) {
        int result;
        while (true) {
            if (scanner.hasNextInt()) {
                result = scanner.nextInt();
                if (isCorrectRange(result, min, max)) {
                    return result;
                }
                System.err.printf("Значение должно быть от %d до %d включительно\n", min, min);
            } else {
                scanner.next();
                System.err.println("Значение должно быть целочисленным");
            }
        }
    }

    private static boolean isCorrectRange(int value, int min, int max) {
        return min <= value && value <= max;
    }
}
