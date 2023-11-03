package core.two.lesson13.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Magician {

  private final MagicianRace magicianRace;

  private final List<CrystalType> crystals = new ArrayList<>();

  public Magician(MagicianRace magicianRace) {
    this.magicianRace = magicianRace;
  }

  public void addAll(Collection<CrystalType> crystals) {
    this.crystals.addAll(crystals);
  }

  public int getCrystalCount(CrystalType type) {
    return crystals.stream()
        .filter(c -> c == type)
        .mapToInt(c -> 1)
        .sum();
  }

  public void printInfo() {
    System.out.printf("У %s магов: %s: %d и %s: %d кристаллов.\n", getName(),
                      CrystalType.RED, getCrystalCount(CrystalType.RED),
                      CrystalType.WHITE, getCrystalCount(CrystalType.WHITE)
    );
  }

  public String getName() {
    return magicianRace.getValue();
  }
}
