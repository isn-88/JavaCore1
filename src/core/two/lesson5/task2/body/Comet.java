package core.two.lesson5.task2.body;


public class Comet extends SpaceBody {

  private double circulationPeriod;


  public Comet(String name, int diameter, double weight, double circulationPeriod) {
    super(name, diameter, weight);
    this.circulationPeriod = circulationPeriod;
  }

  public double getCirculationPeriod() {
    return circulationPeriod;
  }

  @Override
  public String toString() {
    return "Comet{" +
           "name=" + getName() +
           ", circulationPeriod=" + circulationPeriod +
           '}';
  }
}
