package core.two.lesson15.thread;

import core.two.lesson15.util.EventUtil;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class EventInitTask implements Callable<Integer> {

  private final Path pathSource;
  private final Path pathResult;
  private final ExecutorService executor;
  private final long callDelayMin;
  private final long callDelayMax;

  public EventInitTask(Path pathSource, Path pathResult, ExecutorService executor,
                       long callDelayMin, long callDelayMax) {
    this.pathSource = pathSource;
    this.pathResult = pathResult;
    this.executor = executor;
    this.callDelayMin = callDelayMin;
    this.callDelayMax = callDelayMax;
  }

  @Override
  public Integer call() {
    Set<Integer> sourceIds = getAllEventIdFromFile(pathSource);
    Set<Integer> resultIds = getAllEventIdFromFile(pathResult);
    int lastIds = getLastIds(sourceIds);
    sourceIds.removeAll(resultIds);
    System.out.println("Init: to process ids " + sourceIds);
    getAllEventsToProcessFromFile(pathSource, sourceIds);
    return lastIds;
  }

  private Set<Integer> getAllEventIdFromFile(Path path) {
    try (BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
      return reader.lines()
          .map(EventUtil::parseId)
          .filter(Objects::nonNull)
          .collect(Collectors.toSet());
    } catch (IOException e) {
      System.err.println("Error read ids from file: " + e.getMessage());
      return new HashSet<>();
    }
  }

  private void getAllEventsToProcessFromFile(Path pathSource, Set<Integer> ids) {
    try (BufferedReader reader = new BufferedReader(new FileReader(pathSource.toFile()))) {
      reader.lines()
          .map(EventUtil::parseEvent)
          .filter(Objects::nonNull)
          .filter(event -> ids.contains(event.getId()))
          .map(e -> new EventTask(e, pathResult, callDelayMin, callDelayMax))
          .forEach(executor::submit);
    } catch (IOException e) {
      System.err.println("Error read event from file: " + e.getMessage());
    }
  }

  private int getLastIds(Set<Integer> ids) {
    return ids.stream()
        .mapToInt(Integer::intValue)
        .max().orElse(0);
  }

}
