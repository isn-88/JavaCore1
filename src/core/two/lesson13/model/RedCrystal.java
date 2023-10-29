package core.two.lesson13.model;

public class RedCrystal implements Valuable {

  @Override
  public CrystalType getType() {
    return CrystalType.RED;
  }

  @Override
  public String toString() {
    return "Red";
  }

}
