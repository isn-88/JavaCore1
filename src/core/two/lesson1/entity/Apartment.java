package core.two.lesson1.entity;


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

  @Override
  public String toString() {
    return String.format("Квартира %d, количество комнат: %d\n%s",
                         number, rooms != null ? rooms.length : 0,
                         allRoomsToText());
  }

  private String allRoomsToText() {
    StringBuilder builder = new StringBuilder();
      for (Room room : rooms) {
        if (room != null) {
          builder.append("\t\t\t").append(room);
        }
      }
    return builder.toString();
  }
}
