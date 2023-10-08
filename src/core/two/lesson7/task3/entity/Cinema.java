package core.two.lesson7.task3.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;


public class Cinema {

  private final Map<Integer, List<Film>> films = new TreeMap<>();


  public Cinema() {
  }

  public Cinema(Collection<Film> films) {
    for (Film film : films) {
      addFilm(film);
    }
  }

  public boolean addFilm(Film film) {
    List<Film> filmsOfYear;
    if (films.containsKey(film.getProdYear())) {
      filmsOfYear = films.get(film.getProdYear());
      if (filmsOfYear.contains(film)) {
        return false;
      }
      filmsOfYear.add(film);
    } else {
      filmsOfYear = new ArrayList<>();
      filmsOfYear.add(film);
      films.put(film.getProdYear(), filmsOfYear);
    }
    return true;
  }

  public List<Film> getAllFilmsOfYear(int year) {
    if (films.containsKey(year)) {
      return List.copyOf(films.get(year));
    }
    return List.of();
  }

  public List<Film> getAllFilmsOfYearAndMonth(int year, int month) {
    List<Film> filmsOfYear = new ArrayList<>(getAllFilmsOfYear(year));
    Iterator<Film> iterator = filmsOfYear.iterator();
    while (iterator.hasNext()) {
      Film film = iterator.next();
      if (film.getProdMonth() != month) {
        iterator.remove();
      }
    }
    return filmsOfYear;
  }

  public List<Film> getFilmsByGenre(Genre genre) {
    List<Film> filmByGenre = new ArrayList<>();
    for (List<Film> filmList : films.values()) {
      for (Film film : filmList) {
        if (film.getGenre() == genre) {
          filmByGenre.add(film);
        }
      }
    }
    return filmByGenre;
  }

  public List<Film> getFilmsTop10() {
    List<Film> allFilms = new ArrayList<>();

    for (List<Film> filmList : films.values()) {
      allFilms.addAll(filmList);
    }
    allFilms.sort(new Comparator<Film>() {
      @Override
      public int compare(Film film1, Film film2) {
        return Double.compare(film2.getRating(), film1.getRating());
      }
    });

    return allFilms.subList(0, Math.min(10, allFilms.size()));
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Cinema cinema = (Cinema) o;
    return Objects.equals(films, cinema.films);
  }

  @Override
  public int hashCode() {
    return Objects.hash(films);
  }

  @Override
  public String toString() {
    return "Cinema{" +
           "films=" + films +
           '}';
  }
}
