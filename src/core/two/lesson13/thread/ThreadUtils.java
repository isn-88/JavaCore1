package core.two.lesson13.thread;

public final class ThreadUtils {

  private ThreadUtils() {
  }

  public static void start(Runnable... runnable) {
    for (Runnable run : runnable) {
      new Thread(run).start();
    }
  }

}
