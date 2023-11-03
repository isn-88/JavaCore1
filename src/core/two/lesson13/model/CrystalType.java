package core.two.lesson13.model;

public enum CrystalType {

  RED("Red"),
  WHITE("White");

  private final String value;

  CrystalType(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return value;
  }
}
