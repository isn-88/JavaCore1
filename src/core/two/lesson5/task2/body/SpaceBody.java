package core.two.lesson5.task2.body;


public abstract class SpaceBody {

  private final String name;
  private final int diameter;
  private final double weight;


  public SpaceBody(String name, int diameter, double weight) {
    this.name = name;
    this.diameter = diameter;
    this.weight = weight;
  }

  public String getName() {
    return name;
  }

  public int getDiameter() {
    return diameter;
  }

  public double getWeight() {
    return weight;
  }

  public int compareTo(SpaceBody spaceBody) {
    if (spaceBody == null) {
      return 1;
    }
    return Double.compare(weight, spaceBody.getWeight());
  }
}
