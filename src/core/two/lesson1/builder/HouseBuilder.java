package core.two.lesson1.builder;


import core.two.lesson1.entity.Apartment;
import core.two.lesson1.entity.Floor;
import core.two.lesson1.entity.House;
import core.two.lesson1.entity.Room;


public class HouseBuilder {

  public static final boolean[] STUDIO = new boolean[]{true};
  public static final boolean[] ONE = new boolean[]{false};
  public static final boolean[] TWO = new boolean[]{false, false};
  public static final boolean[] EURO_TWO = new boolean[]{false, true};
  public static final boolean[] THREE = new boolean[]{false, false, false};
  public static final boolean[] EURO_THREE = new boolean[]{false, true, false};


  public static House houseBuild(int houseNumber, int floorsCount, int apartPerFloor) {
    parameterValidation(houseNumber, floorsCount, apartPerFloor);
    int apartNumber = 1;
    Floor[] floors = new Floor[floorsCount];
    for (int floor = 0; floor < floorsCount; floor++) {
      Apartment[] apartments = new Apartment[apartPerFloor];
      for (int apart = 0; apart < apartPerFloor; apart++) {
        apartments[apart] = getApartForFloor(apart, apartNumber++);
      }
      floors[floor] = new Floor(floor + 1, apartments);
    }
    return new House(houseNumber, floors);
  }

  public static Apartment apartmentBuild(int number, boolean... isPassage) {
    return new Apartment(number, roomsBuild(isPassage));
  }

  public static Room[] roomsBuild(boolean... isPassage) {
    if (isPassage != null && isPassage.length > 0) {
      Room[] rooms = new Room[isPassage.length];
      for (int i = 0; i < isPassage.length; i++) {
        rooms[i] = new Room(isPassage[i]);
      }
      return rooms;
    }
    return new Room[0];
  }

  private static Apartment getApartForFloor(int apartCount, int apartNumber) {
    return switch (apartCount % 6) {
      case 0 -> apartmentBuild(apartNumber, STUDIO);
      case 1 -> apartmentBuild(apartNumber, ONE);
      case 2 -> apartmentBuild(apartNumber, TWO);
      case 3 -> apartmentBuild(apartNumber, EURO_TWO);
      case 4 -> apartmentBuild(apartNumber, THREE);
      case 5 -> apartmentBuild(apartNumber, EURO_THREE);
      default -> throw new IllegalStateException("Unexpected value: " + apartCount % 6);
    };
  }

  private static void parameterValidation(int houseNumber, int floorsCount, int apartPerFloor) {
    if (houseNumber <= 0 || floorsCount <= 0 || apartPerFloor <= 0) {
      throw new IllegalStateException("Invalid parameter value");
    }
  }
}
