package lesson3;


/**
 * Задание 3
 * Даны два прямоугольных треугольника.
 * Каждый из них задается двумя целочисленными переменными a и b - стороны треугольника.
 * Написать код, в котором вычисляется площадь каждого треугольника и затем эти площади сравниваются друг с другом.
 * Для этого понадобится написать 2 функции.
 * Первая: по двум сторонам прямоугольного треугольника возвращает его площадь.
 * Вторая: сравнивает переданные площади двух треугольников и выводит на консоль первый треугольник больше, меньше или равен второму.
 * Учитывать, что площадь может быть вещественным числом.
 */
public class Task3 {

    public static void main(String[] args) {
        int triangle1a = 8;
        int triangle1b = 3;
        int triangle2a = 5;
        int triangle2b = 5;
        double squareTriangle1 = squareTriangle(triangle1a, triangle1b);
        double squareTriangle2 = squareTriangle(triangle2a, triangle2b);
        triangleEquals(squareTriangle1, squareTriangle2);
    }

    public static double squareTriangle(int a, int b) {
        return (double) (a * b) / 2;
    }

    public static void triangleEquals(double square1, double square2) {
        if (square1 > square2) {
            System.out.println("Первый треугольник больше (" + square1 + " > " + square2 + ")");
        } else if (square1 < square2) {
            System.out.println("Первый треугольник меньше (" + square1 + " < " + square2 + ")");
        } else {
            System.out.println("Треугольники равны");
        }
    }
}
