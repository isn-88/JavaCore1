package core.two.lesson13.thread;

import core.two.lesson13.Game;
import core.two.lesson13.Status;
import core.two.lesson13.model.Magician;

public class Rocket implements Runnable {

  private final Game game;
  private final Magician magician;

  public Rocket(Game game, Magician magician) {
    this.game = game;
    this.magician = magician;
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
            magician.addAll(game.getCrystals());
            game.getCrystals().clear();
          }
          magician.printInfo();
          if (game.isWinner(magician)) {
            break;
          }
          game.getLock().wait();
        }
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

}
