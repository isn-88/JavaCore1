package core.two.lesson1;

public class Room {

  private final boolean isPassage;

  public Room(boolean isPassage) {
    this.isPassage = isPassage;
  }

  public boolean isPassage() {
    return isPassage;
  }

  public void print() {
    System.out.printf("Комната %s\n",
                      isPassage ? "проходная" : "не проходная");
  }
}
