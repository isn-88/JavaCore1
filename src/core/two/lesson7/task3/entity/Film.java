package core.two.lesson7.task3.entity;

import java.util.Objects;


public class Film {

  private final int id;
  private final int prodYear;
  private final int prodMonth;
  private final Genre genre;
  private double rating;

  public Film(int id, int prodYear, int prodMonth, Genre genre, double rating) {
    this.id = id;
    this.prodYear = prodYear;
    this.prodMonth = prodMonth;
    this.genre = genre;
    this.rating = rating;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Film film = (Film) o;
    return id == film.id &&
           prodYear == film.prodYear &&
           prodMonth == film.prodMonth &&
           Double.compare(film.rating, rating) == 0 &&
           genre == film.genre;
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, prodYear, prodMonth, genre, rating);
  }

  @Override
  public String toString() {
    return "Film{" +
           "id=" + id +
           ", prodYear=" + prodYear +
           ", prodMonth=" + prodMonth +
           ", genre=" + genre +
           ", rating=" + rating +
           '}';
  }

  public int getId() {
    return id;
  }

  public int getProdYear() {
    return prodYear;
  }

  public int getProdMonth() {
    return prodMonth;
  }

  public Genre getGenre() {
    return genre;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }
}
