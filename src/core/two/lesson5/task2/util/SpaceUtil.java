package core.two.lesson5.task2.util;

import core.two.lesson5.task2.body.SpaceBody;
import core.two.lesson5.task2.body.Star;


public final class SpaceUtil {

  private static final double GRAVITY = 6.6743e-11;


  private SpaceUtil() {}


  public static double gravity(SpaceBody body1, SpaceBody body2, double distance) {
    return GRAVITY * body1.getWeight() * body2.getWeight() / Math.pow(distance, 2);
  }


  public static boolean isStar(SpaceBody spaceBody) {
    return spaceBody instanceof Star;
  }
}
