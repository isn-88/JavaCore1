package core.two.lesson13.util;

import core.two.lesson13.model.CrystalType;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public final class CrystalGenerator {

  private static final Random random = new Random(System.currentTimeMillis());

  private CrystalGenerator() {
  }

  public static List<CrystalType> generate(int min, int max) {
    if (max <= 0) {
      return new ArrayList<>();
    }
    List<CrystalType> crystals = new ArrayList<>(max);
    int randomCount = random.nextInt(max + 1 - min) + min;
    for (int i = 0; i < randomCount; i++) {
      crystals.add(
          (random.nextInt(2) == 0)
          ? CrystalType.RED
          : CrystalType.WHITE
      );
    }
    return crystals;
  }

}
