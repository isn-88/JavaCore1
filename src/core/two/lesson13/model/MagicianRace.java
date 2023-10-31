package core.two.lesson13.model;

public enum MagicianRace {

  FIRE("Fire"),
  AIR("Air");

  private final String value;

  MagicianRace(String value) {
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
