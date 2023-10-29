package core.two.lesson13.model;

public class WhiteCrystal implements Valuable {

  @Override
  public CrystalType getType() {
    return CrystalType.WHITE;
  }

  @Override
  public String toString() {
    return "White";
  }

}
