package core.two.lesson1.entity;


public class Floor {

  private final int level;

  private final Apartment[] apartments;

  public Floor(int level, Apartment[] apartments) {
    this.level = level;
    this.apartments = apartments;
  }

  public int getLevel() {
    return level;
  }

  public Apartment[] getApartments() {
    return apartments;
  }

  @Override
  public String toString() {
    return String.format("Этаж %d, количество квартир: %d\n%s",
                         level, apartments != null ? apartments.length : 0,
                         allApartmentsToText());
  }

  private String allApartmentsToText() {
    StringBuilder builder = new StringBuilder();
      for (Apartment apartment : apartments) {
        if (apartment != null) {
          builder.append("\t\t").append(apartment);
        }
      }
    return builder.toString();
  }
}
