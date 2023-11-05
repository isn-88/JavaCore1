package core.two.lesson15.util;

import java.util.Random;

public final class PhoneGenerator {

  private static final Random random = new Random();
  private static final String CODE_BY = "+375";
  private static final String[] CODE_ZONE = {"25", "29", "33", "44"};


  private PhoneGenerator() {
  }

  public static String getRandom() {
    return switch (random.nextInt(6)) {
      case 0 -> "%s%s%s%s%s".formatted(CODE_BY, getRandomCodeZone(), getRandomMobileCode(),
                                       getRandomNumber(), getRandomNumber()
      );
      case 1 -> "%s %s %s %s %s".formatted(CODE_BY, getRandomCodeZone(), getRandomMobileCode(),
                                           getRandomNumber(), getRandomNumber()
      );
      case 2 -> "%s (%s) %s-%s-%s".formatted(CODE_BY, getRandomCodeZone(), getRandomMobileCode(),
                                             getRandomNumber(), getRandomNumber()
      );
      case 3 -> "(%s) %s-%s-%s".formatted(getRandomCodeZone(), getRandomMobileCode(),
                                          getRandomNumber(), getRandomNumber()
      );
      case 4 -> "%s %s %s %s".formatted(getRandomCodeZone(), getRandomMobileCode(),
                                        getRandomNumber(), getRandomNumber()
      );
      case 5 -> "%s%s%s%s".formatted(getRandomCodeZone(), getRandomMobileCode(), getRandomNumber(),
                                     getRandomNumber()
      );
      default -> throw new IllegalStateException("Unexpected value");
    };
  }

  private static String getRandomCodeZone() {
    return CODE_ZONE[random.nextInt(CODE_ZONE.length)];
  }

  private static String getRandomMobileCode() {
    return "%d%d%d".formatted(getRandomDigit(), getRandomDigit(), getRandomDigit());
  }

  private static String getRandomNumber() {
    return "%d%d".formatted(getRandomDigit(), getRandomDigit());
  }

  private static int getRandomDigit() {
    return random.nextInt(10);
  }

}
