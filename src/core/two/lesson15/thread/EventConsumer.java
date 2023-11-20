package core.two.lesson15.thread;

import core.two.lesson15.entity.Event;
import core.two.lesson15.util.EventUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;

public class EventConsumer implements Callable<Integer> {

  private final Path pathFrom;
  private final Path pathTo;
  private final Integer lastEventId;
  private final ExecutorService executor;
  private final long callDelayMin;
  private final long callDelayMax;
  private Integer currentEventId;

  public EventConsumer(Path pathFrom, Path pathTo, Integer lastEventId, ExecutorService executor,
                       long callDelayMin, long callDelayMax) {
    this.pathFrom = pathFrom;
    this.pathTo = pathTo;
    this.lastEventId = lastEventId;
    currentEventId = lastEventId;
    this.executor = executor;
    this.callDelayMin = callDelayMin;
    this.callDelayMax = callDelayMax;
  }

  @Override
  public Integer call() {
    generateEventTasks();
    return currentEventId;
  }

  private void generateEventTasks() {
    try (BufferedReader reader = new BufferedReader(new FileReader(pathFrom.toFile()))) {
      while (reader.ready()) {
        Event event = EventUtil.parseEvent(reader.readLine());
        int id = event.getId();
        if (id > lastEventId) {
          EventTask task = new EventTask(event, pathTo, callDelayMin, callDelayMax);
          executor.submit(task);
          currentEventId = id;
        }
      }
    } catch (IOException e) {
      System.err.println("Consumer: error consume " + e.getMessage());
    }
  }
}
