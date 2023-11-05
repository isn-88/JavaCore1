package core.two.lesson15.util;

import core.two.lesson15.repo.NameRepo;
import java.util.Random;

public final class NameGenerator {

  private static final Random random = new Random();

  private NameGenerator() {
  }

  public static String getRandomName() {
    return (random.nextInt(2) == 0)
           ? getRandomMaleName()
           : getRandomFemaleName();
  }

  private static String getRandomMaleName() {
    return String.join(
        " ",
        NameRepo.getMaleLastnameRandom(),
        NameRepo.getMaleFirstnameRandom()
    );
  }

  private static String getRandomFemaleName() {
    return String.join(
        " ",
        NameRepo.getFemaleLastnameRandom(),
        NameRepo.getFemaleFirstnameRandom()
    );
  }

}
