package core.two.lesson7.task3;

import core.two.lesson7.task3.entity.Cinema;
import core.two.lesson7.task3.entity.Film;
import core.two.lesson7.task3.entity.Genre;

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

  public static void main(String[] args) {

    Cinema cinema = new Cinema(FilmUtil.getAllFilms());
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
}
