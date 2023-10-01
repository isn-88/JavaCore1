package core.two.lesson5.task2.body;


public class Asteroid extends SpaceBody {

  private final boolean hasSatellite;


  public Asteroid(String name, int diameter, double weight, boolean hasSatellite) {
    super(name, diameter, weight);
    this.hasSatellite = hasSatellite;
  }

  public final boolean hasSatellite() {
    return hasSatellite;
  }

  @Override
  public String toString() {
    return "Asteroid{" +
           "name=" + getName() +
           ", hasSatellite=" + hasSatellite +
           '}';
  }
}
