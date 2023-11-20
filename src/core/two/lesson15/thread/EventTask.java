package core.two.lesson15.thread;

import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;

import core.two.lesson15.entity.Event;
import core.two.lesson15.util.EventUtil;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import java.time.Instant;
import java.util.Random;

public class EventTask implements Runnable {

  private static final Random random = new Random();

  private final Event event;
  private final Path path;
  private final long callDelayMin;
  private final long callDelayMax;

  public EventTask(Event event, Path path, long callDelayMin, long callDelayMax) {
    this.event = event;
    this.path = path;
    this.callDelayMin = callDelayMin;
    this.callDelayMax = callDelayMax;
  }


  @Override
  public void run() {
    try {
      Instant start = Instant.now();
      System.out.println(Thread.currentThread().getName() + " call: " + event.getId());
      Thread.sleep(random.nextInt((int) (callDelayMax - callDelayMin)) + callDelayMin);
      String report = EventUtil.getReport(event);
      Files.writeString(path, report + "\n", CREATE, APPEND);
      System.out.println(Thread.currentThread().getName() + " done: " + event.getId() +
                         " call time: " + Duration.between(start, Instant.now()).toMillis() + " ms");
    } catch (InterruptedException | IOException e) {
      System.err.println("Dispatcher: error for processing");
    }
  }
}
