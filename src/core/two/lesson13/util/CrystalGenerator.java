package core.two.lesson13.util;

import core.two.lesson13.model.RedCrystal;
import core.two.lesson13.model.Valuable;
import core.two.lesson13.model.WhiteCrystal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class CrystalGenerator {

  private static final Random random = new Random(System.currentTimeMillis());

  private CrystalGenerator() {
  }

  public static List<Valuable> generate(int min, int max) {
    if (max <= 0) {
      return new ArrayList<>();
    }
    List<Valuable> crystals = new ArrayList<>(max);
    int randomCount = random.nextInt(max + 1 - min) + min;
    for (int i = 0; i < randomCount; i++) {
      crystals.add(
          (random.nextInt(2) == 0)
          ? new RedCrystal()
          : new WhiteCrystal()
      );
    }
    return crystals;
  }

}
