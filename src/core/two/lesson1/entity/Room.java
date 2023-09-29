package core.two.lesson1.entity;


public class Room {

  private final boolean isPassage;

  public Room(boolean isPassage) {
    this.isPassage = isPassage;
  }

  public boolean isPassage() {
    return isPassage;
  }

  @Override
  public String toString() {
    return String.format("Комната %s\n", isPassage ? "проходная" : "не проходная");
  }
}
