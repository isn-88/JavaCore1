package core.two.lesson15.entity;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Event {

  private static final DateTimeFormatter INPUT_FORMATTER = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
  private static final String PHONE_FORMAT = "+375 (%s) %s-%s-%s";
  private static final String NUMBER_PATTERN =
      "(\\+375)?[ -]?\\(?(\\d{2})\\)?[ -]?(\\d{3})[ -]?(\\d{2})[ -]?(\\d{2})";
  private static final Pattern PHONE_PATTERN = Pattern.compile(NUMBER_PATTERN);

  private final Integer id;
  private final LocalDateTime dateTime;
  private final String name;
  private final String phone;
  private final String message;


  public Event(String id, String dateTime, String name, String phone, String message) {
    this.id = parseId(id.trim());
    this.dateTime = LocalDateTime.from(INPUT_FORMATTER.parse(dateTime.trim()));
    this.name = name.trim();
    this.phone = parsePhone(phone.trim());
    this.message = message.trim();
  }

  public Integer getId() {
    return id;
  }

  public LocalDateTime getDateTime() {
    return dateTime;
  }

  public String getName() {
    return name;
  }

  public String getPhone() {
    return phone;
  }

  public String getMessage() {
    return message;
  }

  private int parseId(String value) {
    try {
      return Integer.parseInt(value.replaceAll("\\D", ""));
    } catch (NumberFormatException e) {
      System.err.println("Error parse value: " + id);
      return 0;
    }
  }

  private String parsePhone(String value) {
    if (value == null || value.isEmpty()) {
      return "";
    }
    Matcher matcher = PHONE_PATTERN.matcher(value);
    if (matcher.find()) {
      return PHONE_FORMAT.formatted(
          matcher.group(2), matcher.group(3), matcher.group(4), matcher.group(5)
      );
    }
    return "";
  }

}
