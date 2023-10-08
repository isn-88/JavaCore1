package core.two.lesson7.task3;

import core.two.lesson7.task3.entity.Cinema;
import core.two.lesson7.task3.entity.Film;
import core.two.lesson7.task3.entity.Genre;
import java.util.ArrayList;
import java.util.List;


/**
 * Задание 1
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания,
 * Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него
 * (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class Task {

  private static final List<Film> FILMS = filmInit();


  public static void main(String[] args) {

    Cinema cinema = new Cinema(FILMS);
    System.out.println("Фильм добавлен? " +
                       cinema.addFilm(new Film(21, 1997, 2, Genre.DRAMA, 8.7)));
    System.out.println("\nФильм добавлен? " +
                       cinema.addFilm(new Film(21, 1997, 2, Genre.DRAMA, 8.7)));

    System.out.println("\nВсе фильмы в кино:\n" + cinema);

    System.out.println("\nВсе фильмы 1994 года:\n" + cinema.getAllFilmsOfYear(1994));

    System.out.println("\nВсе фильмы июня 1994 года:\n" +
                       cinema.getAllFilmsOfYearAndMonth(1994, 6));

    System.out.println("\nВсе фильмы жанра фантастика:\n" + cinema.getFilmsByGenre(Genre.FANTASY));

    System.out.println("\n10 лучших фильмов:\n" + cinema.getFilmsTop10());
  }


  private static List<Film> filmInit() {
    List<Film> films = new ArrayList<>();
    films.add(new Film(1, 1999, 12, Genre.DRAMA, 9.1));
    films.add(new Film(2, 1994, 9, Genre.DRAMA, 9.0));
    films.add(new Film(3, 1994, 6, Genre.DRAMA, 9.0));
    films.add(new Film(4, 2011, 9, Genre.DRAMA, 9.0));
    films.add(new Film(5, 1993, 11, Genre.DRAMA, 8.9));
    films.add(new Film(6, 2014, 10, Genre.FANTASY, 8.9));
    films.add(new Film(7, 2003, 12, Genre.FANTASY, 8.9));
    films.add(new Film(8, 1999, 9, Genre.THRILLER, 8.8));
    films.add(new Film(9, 2017, 10, Genre.CARTOON, 8.8));
    films.add(new Film(10, 2001, 7, Genre.CARTOON, 8.8));
    films.add(new Film(11, 1994, 5, Genre.DRAMA, 8.8));
    films.add(new Film(12, 1973, 9, Genre.COMEDY, 8.8));
    films.add(new Film(13, 2001, 12, Genre.FANTASY, 8.8));
    films.add(new Film(14, 2002, 12, Genre.FANTASY, 8.8));
    films.add(new Film(15, 1981, 7, Genre.DETECTIVE, 8.8));
    films.add(new Film(16, 2001, 4, Genre.CARTOON, 8.8));
    films.add(new Film(17, 1980, 2, Genre.DETECTIVE, 8.7));
    films.add(new Film(18, 1994, 6, Genre.CARTOON, 8.7));
    films.add(new Film(19, 1991, 7, Genre.FANTASY, 8.7));
    films.add(new Film(20, 1985, 7, Genre.FANTASY, 8.7));
    return films;
  }
}
