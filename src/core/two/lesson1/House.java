package core.two.lesson1;

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

  public void print() {
    System.out.printf("Дом %d, количество этажей: %d\n",
                      number, floors != null ? floors.length : 0);
  }
}
