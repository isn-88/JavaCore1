package core.two.lesson1;


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
    Room roomPass = new Room(true);
    Room room = new Room(false);

    Room[] oneRoom = new Room[]{room};
    Room[] studio = new Room[]{roomPass};
    Room[] twoRooms = new Room[]{room, room};
    Room[] three = new Room[]{room, room, room};
    Room[] three1Pass = new Room[] {roomPass, room, room};

    Apartment apart1 = new Apartment(1, oneRoom);
    Apartment apart2 = new Apartment(2, twoRooms);
    Apartment apart3 = new Apartment(3, three);
    Apartment apart4 = new Apartment(4, studio);
    Apartment apart5 = new Apartment(5, twoRooms);
    Apartment apart6 = new Apartment(6, three1Pass);
    Apartment apart7 = new Apartment(7, twoRooms);
    Apartment apart8 = new Apartment(8, three1Pass);
    Apartment apart9 = new Apartment(9, studio);

    Floor floor1 = new Floor(2, new Apartment[]{
        apart1, apart2, apart3
    });
    Floor floor2 = new Floor(3, new Apartment[]{
        apart4, apart5, apart6
    });
    Floor floor3 = new Floor(4, new Apartment[]{
        apart7, apart8, apart9
    });

    House house1 = new House(1, new Floor[]{
        null, floor1, floor2, floor3
    });

    printAllInformation(house1);
  }

  private static void printAllInformation(House house) {
    house.print();
    for (Floor floor : house.getFloors()) {
      if (floor != null) {
        floor.print();
        for (Apartment apartment : floor.getApartments()) {
          if (apartment != null) {
            apartment.print();
            for (Room room : apartment.getRooms()) {
              if (room != null) {
                room.print();
              }
            }
          }
        }
      }
    }
  }
}
