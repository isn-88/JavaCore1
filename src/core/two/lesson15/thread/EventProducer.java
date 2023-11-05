package core.two.lesson15.thread;

import core.two.lesson15.util.EventUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Objects;
import java.util.concurrent.Callable;

public class EventProducer implements Callable<Integer> {

  private final Path path;
  private final long generateDelay;

  public EventProducer(Path path, long generateDelay) {
    this.path = path;
    this.generateDelay = generateDelay;
  }

  @Override
  public Integer call() {
    Integer lastNumberEvent = findLastIdFromFile(path);
    int writeEvents = 0;
    try {
      int currentEvent = (lastNumberEvent != null) ? lastNumberEvent : 0;
      while (!Thread.currentThread().isInterrupted()) {
        String event = eventFormat(++currentEvent, EventUtil.getRandomEvent());
        Files.writeString(path, event, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        writeEvents++;
        Thread.sleep(generateDelay);
      }
    } catch (InterruptedException ex) {
      System.err.println("EventRegister stopped.");
    } catch (Exception ex) {
      System.err.println(ex.getMessage());
    }
    return writeEvents;
  }

  private Integer findLastIdFromFile(Path path) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
      return reader.lines()
          .map(EventUtil::parseId)
          .filter(Objects::nonNull)
          .mapToInt(Integer::intValue)
          .max().orElse(0);
    } catch (IOException e) {
      System.err.println("Producer: error from seek last ID " + e.getMessage());
      return null;
    }
  }

  private String eventFormat(int last, String event) {
    return "%d, %s\n".formatted(last, event);
  }

}
