package core.two.lesson13.thread;

import core.two.lesson13.Game;
import core.two.lesson13.Status;

public class Timer implements Runnable {

  private static final int WAIT = 500;

  private final Game game;

  public Timer(Game game) {
    this.game = game;
  }

  @Override
  public void run() {
    synchronized (game.getLock()) {
      try {
        game.getLock().wait(WAIT);
        game.setStatus(Status.RUN);
        while (game.getStatus() != Status.END) {
          print();
          game.getLock().notifyAll();
          game.getLock().wait(WAIT);
        }
        game.getLock().notifyAll();
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
  }

  private void print() {
    System.out.println("\nНаступила полночь");
  }

}
