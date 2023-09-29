package core.two.lesson1;


import core.two.lesson1.builder.HouseBuilder;
import core.two.lesson1.entity.House;


/**
 * Задание 1
 * Представить в виде классов и их композиции следующую модель.
 * - Каждый дом содержит свой номер (int), и множество этажей (массив).
 * - Каждый этаж содержит номер этажа (int), и множество квартир (массив).
 * - Каждая квартира содержит свой номер (int), и множество комнат (массив).
 * - Каждая комната содержит поле проходная она или нет (boolean).
 * В каждом классе реализовать метод print, который на консоль выводит информацию об объекте
 * (должны присутствовать все поля объекта!).
 * Например, метод print класса этаж должен выводить на консоль:
 * “Этаж 2, количество квартир 18”
 * Создание всех объектов вынести в отдельный класс с методом main.
 * Там же реализовать метод printAllInformation, который на вход принимает объект типа дом,
 * и выводит информацию о нем, его этажах, квартирах и комнатах, вызывая методы print.
 */
public class HouseRunner {

  public static void main(String[] args) {

    House house = HouseBuilder.houseBuild(123, 9, 5);

    printAllInformation(house);
  }

  private static void printAllInformation(House house) {
    System.out.println(house);
  }
}
