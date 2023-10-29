package core.two.lesson13.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Wizard {

  private final String name;

  private final List<Valuable> crystals = new ArrayList<>();

  public Wizard(String name) {
    this.name = name;
  }

  public void addAll(Collection<Valuable> crystals) {
    this.crystals.addAll(crystals);
  }

  public int getCrystalCount(CrystalType type) {
    return crystals.stream()
        .filter(c -> c.getType() == type)
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
    return name;
  }
}
