package lesson3;


/**
 * Задание 1
 * В переменной minutes лежит число от 0 до 59.
 * Написать функцию, которая принимает в качестве параметра значение переменной minutes и выводит на консоль
 * в какую четверть часа попадает это число (в первую, вторую, третью или четвертую).
 * Протестировать функцию в main.
 */
public class Task1 {

    public static void main(String[] args) {
        int minutes = 15;
        partHour(minutes);
    }
    
    public static void partHour(int minutes) {
        if (isRange(minutes, 0, 15)) {
            System.out.println("Первая четверть часа.");
        } else if (isRange(minutes, 15, 30)) {
            System.out.println("Вторая четверть часа.");
        } else if (isRange(minutes, 30, 45)) {
            System.out.println("Третья четверть часа.");
        } else if (isRange(minutes, 45, 60)) {
            System.out.println("Четвёртая четверть часа.");
        } else {
            System.out.println("Недопустимое значение минут: " + minutes);
        }
    }

    public static boolean isRange(int value, int begin, int endExcluded) {
        return begin <= value && value < endExcluded;
    }
}
