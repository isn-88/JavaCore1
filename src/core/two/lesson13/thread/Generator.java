package core.two.lesson13.thread;

import core.two.lesson13.Game;
import core.two.lesson13.Status;
import core.two.lesson13.model.CrystalType;
import core.two.lesson13.util.CrystalGenerator;
import java.util.Collection;

public class Generator implements Runnable {

  private final Game game;

  public Generator(Game game) {
    this.game = game;
  }

  @Override
  public void run() {

    synchronized (game.getLock()) {
      try {
        while (game.getStatus() == Status.INIT) {
          game.getLock().wait();
        }
        while (game.getStatus() == Status.RUN) {
          synchronized (game.getCrystals()) {
            Collection<CrystalType> crystalGen = CrystalGenerator.generate(
                game.getMinCrystalPerDay(),
                game.getMaxCrystalPerDay()
            );
            game.getCrystals().addAll(crystalGen);
            printInfo(crystalGen);
          }
          game.getLock().wait();
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  public void printInfo(Collection<CrystalType> crystals) {
    System.out.printf("Сгенерированы кристаллы: %s\n", crystals);
  }

}
