package lesson3;


/**
 * Задание 2
 * Даны 3 переменные:
 * - operand1 (double)
 * - operand2 (double)
 * - operation (char ‘+’, ‘-’, ‘*’, ‘/’, ‘%’)
 * Написать функцию, которая принимает в качестве параметров эти три переменные и возвращает результат операции.
 * Протестировать функцию в main.
 */
public class Task2 {

    private final static char ADDITION = '+';
    private final static char SUBTRACTION = '-';
    private final static char MULTIPLICATION = '*';
    private final static char DIVISION = '/';
    private final static char MODULUS = '%';

    public static void main(String[] args) {
        double operand1 = 8;
        double operand2 = 5;
        char operation = MODULUS;
        System.out.println(calculate(operand1, operand2, operation));
    }

    private static double calculate(double operand1, double operand2, char operation) {
        return switch (operation) {
            case ADDITION -> operand1 + operand2;
            case SUBTRACTION -> operand1 - operand2;
            case MULTIPLICATION -> operand1 * operand2;
            case DIVISION -> operand1 / operand2;
            case MODULUS -> operand1 % operand2;
            default -> throw new IllegalArgumentException("Неверная математическая операция");
        };
    }
}
