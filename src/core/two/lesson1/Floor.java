package core.two.lesson1;

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

  public void print() {
    System.out.printf("Этаж %d, количество квартир: %d\n",
                      level, apartments != null ? apartments.length : 0);
  }
}
