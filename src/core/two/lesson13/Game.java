package core.two.lesson13;

import core.two.lesson13.model.CrystalType;
import core.two.lesson13.model.Valuable;
import core.two.lesson13.model.Wizard;
import core.two.lesson13.thread.Generator;
import core.two.lesson13.thread.Rocket;
import core.two.lesson13.thread.ThreadUtils;
import core.two.lesson13.thread.Timer;
import java.util.ArrayList;
import java.util.List;

public class Game {

  private Status status = Status.INIT;
  private final Object lock = new Object();
  private final List<Valuable> crystals = new ArrayList<>();
  private final int minCrystalPerDay;
  private final int maxCrystalPerDay;
  private final int countCrystalForWinner;


  public Game(int minCrystalPerDay, int maxCrystalPerDay, int countCrystalForWinner) {
    this.minCrystalPerDay = minCrystalPerDay;
    this.maxCrystalPerDay = maxCrystalPerDay;
    this.countCrystalForWinner = countCrystalForWinner;
  }

  public void start() {
    ThreadUtils.start(
        new Timer(this),
        new Generator(this),
        new Rocket(this, new Wizard("Red")),
        new Rocket(this, new Wizard("White"))
    );
  }

  public boolean isWinner(Wizard wizard) {
    int redCount = wizard.getCrystalCount(CrystalType.RED);
    int whiteCount = wizard.getCrystalCount(CrystalType.WHITE);

    if (redCount >= countCrystalForWinner && whiteCount >= countCrystalForWinner) {
      System.out.printf("Маги %s победили со счётом: %s: %d %s: %d\n", wizard.getName(),
                        CrystalType.RED, redCount, CrystalType.WHITE, whiteCount);
      setStatus(Status.END);
      return true;
    }
    return false;
  }

  public Object getLock() {
    return lock;
  }

  public Status getStatus() {
    return status;
  }

  public synchronized void setStatus(Status status) {
    this.status = status;
  }

  public List<Valuable> getCrystals() {
    return crystals;
  }

  public int getMinCrystalPerDay() {
    return minCrystalPerDay;
  }

  public int getMaxCrystalPerDay() {
    return maxCrystalPerDay;
  }

}
