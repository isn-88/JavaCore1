package core.two.lesson5.task2.body;


public class Meteor extends SpaceBody implements Falling {

  private final double speed;
  private final String tailColor;


  public Meteor(String name, int diameter, double weight, double speed, String tailColor) {
    super(name, diameter, weight);
    this.speed = speed;
    this.tailColor = tailColor;
  }

  public String getTailColor() {
    return tailColor;
  }

  @Override
  public double getSpeed() {
    return speed;
  }

  @Override
  public String toString() {
    return "Meteor{" +
           "name=" + getName() +
           ", speed=" + speed +
           ", tailColor='" + tailColor + '\'' +
           '}';
  }
}
