package core.two.lesson1;

public class Apartment {

  private final int number;

  private final Room[] rooms;

  public Apartment(int number, Room[] rooms) {
    this.number = number;
    this.rooms = rooms;
  }

  public int getNumber() {
    return number;
  }

  public Room[] getRooms() {
    return rooms;
  }

  public void print() {
    System.out.printf("Квартира %d, количество комнат: %d\n",
                      number, rooms != null ? rooms.length : 0);
  }
}
