package core.two.lesson13.thread;

import core.two.lesson13.Game;
import core.two.lesson13.Status;
import core.two.lesson13.model.Wizard;

public class Rocket implements Runnable {

  private final Game game;
  private final Wizard wizard;

  public Rocket(Game game, Wizard wizard) {
    this.game = game;
    this.wizard = wizard;
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
            wizard.addAll(game.getCrystals());
            game.getCrystals().clear();
          }
          wizard.printInfo();
          if (game.isWinner(wizard)) {
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
