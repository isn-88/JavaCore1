package core.two.lesson10.util;

public final class ParserValidator {

  private ParserValidator() {
  }

  public static Integer safeParseToInt(String value) {
    if (value == null) {
      return null;
    }
    try {
      return Integer.valueOf(value);
    } catch (NumberFormatException e) {
      System.err.printf("Can't parse %s\n", e.getMessage());
    }
    return null;
  }

  public static Double safeParseToDouble(String value) {
    if (value == null) {
      return null;
    }
    try {
      return Double.valueOf(value);
    } catch (NumberFormatException e) {
      System.err.printf("Can't parse %s\n", e.getMessage());
    }
    return null;
  }

}
