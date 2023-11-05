package core.two.lesson15.util;

import core.two.lesson15.entity.Event;
import core.two.lesson15.repo.MessageRepo;

public final class EventUtil {

  private EventUtil() {
  }


  public static String getRandomEvent() {
    return String.join(
        ", ",
        TimeGenerator.getInputFormattedCurrentDateTime(),
        NameGenerator.getRandomName(),
        PhoneGenerator.getRandom(),
        MessageRepo.getRandomMessage()
    );
  }

  public static Event parseEvent(String line) {
    if (line == null || line.isEmpty()) {
      return null;
    }
    String[] column = line.split(",", 5);
    if (column.length < 5) {
      return null;
    }
    return new Event(column[0], column[1], column[2], column[3], column[4]);
  }

  public static Integer parseId(String line) {
    try {
      String columnId = line.substring(0, line.indexOf(','));
      return Integer.parseInt(columnId.trim());
    } catch (IndexOutOfBoundsException | NumberFormatException e) {
      return null;
    }
  }

  public static String getReport(Event event) {
    return String.join(", ",
                       event.getId().toString(),
                       TimeGenerator.getOutputFormattedCurrentDateTime(),
                       event.getPhone()
    );
  }
}
