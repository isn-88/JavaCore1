package core.two.lesson5.task2.body;


public class Satellite extends SpaceBody {


  public Satellite(String name, int diameter, double weight) {
    super(name, diameter, weight);
  }

  @Override
  public String toString() {
    return "Satellite{" +
           "name=" + getName() +
           "}";
  }
}
