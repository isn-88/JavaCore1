package core.two.lesson15.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public final class TimeGenerator {

  private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
  private static final DateTimeFormatter OUTPUT_FORMATTER =
      DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
  private TimeGenerator() {
  }

  public static String getInputFormattedCurrentDateTime() {
    return INPUT_FORMATTER.format(getCurrentTime());
  }

  public static String getOutputFormattedCurrentDateTime() {
    return OUTPUT_FORMATTER.format(getCurrentTime());
  }

  private static LocalDateTime getCurrentTime() {
    return LocalDateTime.now()
        .withNano(0);
  }
}
