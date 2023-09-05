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

    public static void main(String[] args) {
        double operand1 = 8;
        double operand2 = 5;
        char operation = '%';
        System.out.println(calculate(operand1, operand2, operation));
    }

    public static double calculate(double operand1, double operand2, char operation) {
        return switch (operation) {
            case '+' -> operand1 + operand2;
            case '-' -> operand1 - operand2;
            case '*' -> operand1 * operand2;
            case '/' -> operand1 / operand2;
            case '%' -> operand1 % operand2;
            default -> throw new IllegalArgumentException("Неверная математическая операция");
        };
    }
}
