package core.two.lesson5.task2;

import core.two.lesson5.task2.body.Meteor;
import core.two.lesson5.task2.body.Meteorite;
import core.two.lesson5.task2.body.Planet;
import core.two.lesson5.task2.body.Satellite;
import core.two.lesson5.task2.body.SpaceBody;
import core.two.lesson5.task2.body.Star;
import core.two.lesson5.task2.util.SpaceUtil;


public class SpaceRunner {

  public static void main(String[] args) {

    new SpaceRunner().run();
  }

  public void run() {
    Meteor small = new Meteor("SmallRedBall", 234, 45, 23, "red");
    Meteorite fe = new Meteorite("FerrumСhunk", 15, 25, true);
    Star solar = new Star("Solar", 1_391_400, 1.9e30, 'G', 6000);

    Satellite moon = new Satellite("Moon", 3474, 7.35e22);
    Planet earl = new Planet("Earl", 12742, 6.0e24, 45, true, new Satellite[]{moon});


    printBodyIsStar(small);
    printBodyIsStar(solar);

    printCompare(small, fe);

    System.out.printf("Притяжение Земли и Луны = %s (H)\n",
                      SpaceUtil.gravity(earl, moon, 3.8e8));

    System.out.println(small);
    System.out.println(fe);
    System.out.println(solar);
    System.out.println(earl);
  }

  public void printBodyIsStar(SpaceBody body) {
    System.out.printf("%s - это %s\n", body.getName(),
                      SpaceUtil.isStar(body) ? "звезда." : "не звезда.");
  }

  public void printCompare(SpaceBody body1, SpaceBody body2) {
    System.out.printf("Масса %s %s %s\n",
                      body1.getName(),
                      textCompare(body1.compareTo(body2)),
                      body2.getName()
                      );
  }

  private String textCompare(int value) {
    return switch (value) {
      case 1 -> "больше";
      case 0 -> "равна";
      case -1 -> "меньше";
      default -> "";
    };
  }

}
