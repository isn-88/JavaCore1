package core.two.lesson5.task2.body;


public class Meteorite extends Meteor {

  private final boolean isFerrum;


  public Meteorite(String name, int diameter, double weight,
                   double speed, String tailColor, boolean isFerrum) {
    super(name, diameter, weight, speed, tailColor);
    this.isFerrum = isFerrum;
  }

  public Meteorite(String name, int diameter, double weight, boolean isFerrum) {
    this(name, diameter, weight, 0.0, "", isFerrum);
  }

  public boolean isFerrum() {
    return isFerrum;
  }

  @Override
  public double getSpeed() {
    return 0.0;
  }

  @Override
  public String toString() {
    return "Meteorite{" +
           "name=" + getName() +
           ", weight=" + getWeight() +
           ", isFerrum=" + isFerrum +
           '}';
  }
}
