package core.two.lesson5.task2.body;


public class Star extends SpaceBody {

  private final char spectralClass;
  private final int colorTemperature;


  public Star(String name, int diameter, double weight, char spectralClass, int colorTemperature) {
    super(name, diameter, weight);
    this.spectralClass = spectralClass;
    this.colorTemperature = colorTemperature;
  }

  public char getSpectralClass() {
    return spectralClass;
  }

  public int getColorTemperature() {
    return colorTemperature;
  }

  @Override
  public String toString() {
    return "Star{" +
           "name=" + getName() +
           ", color=" + colorTemperature +
           '}';
  }
}
