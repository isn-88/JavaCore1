package core.two.lesson1.entity;


public class House {

  private final int number;

  private final Floor[] floors;


  public House(int number, Floor[] floors) {
    this.number = number;
    this.floors = floors;
  }

  public int getNumber() {
    return number;
  }

  public Floor[] getFloors() {
    return floors;
  }

  @Override
  public String toString() {
    return String.format("Дом %d, количество этажей: %d\n%s",
                         number, floors != null ? floors.length : 0,
                         allFloorsToText());
  }

  private String allFloorsToText() {
    StringBuilder builder = new StringBuilder();
      for (Floor floor : floors) {
        if (floor != null) {
          builder.append("\t").append(floor);
        }
      }
    return builder.toString();
  }
}
