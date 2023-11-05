package core.two.lesson15.repo;

import java.util.List;
import java.util.Random;

public final class NameRepo {

  private static final Random random = new Random();
  private static final List<String> maleFirstnames = initMaleFirstname();
  private static final List<String> femaleFirstnames = initFemaleFirstname();
  private static final List<String> maleLastnames = initMaleLastnames();
  private static final List<String> femaleLastnames = initFemaleLastnames();


  private NameRepo() {
  }

  public static String getMaleFirstnameRandom() {
    return getRandomElement(maleFirstnames);
  }

  public static String getMaleLastnameRandom() {
    return getRandomElement(maleLastnames);
  }

  public static String getFemaleFirstnameRandom() {
    return getRandomElement(femaleFirstnames);
  }

  public static String getFemaleLastnameRandom() {
    return getRandomElement(femaleLastnames);
  }

  private static String getRandomElement(List<String> elements) {
    return elements.get(random.nextInt(elements.size()));
  }

  private static List<String> initMaleFirstname() {
    return List.of("Иван", "Василий", "Степан", "Олег", "Евгений", "Сергей", "Пётр", "Игорь",
                   "Виталий", "Алексей", "Владислав", "Денис", "Илья", "Михаил", "Роман", "Семён",
                   "Тимофей", "Фёдор", "Юрий", "Андрей", "Борис", "Григорий", "Егор", "Константин",
                   "Леонид", "Максим", "Николай", "Павел", "Станислав", "Тимофей", "Ярослав"
    );
  }

  private static List<String> initFemaleFirstname() {
    return List.of("Оксана", "Мария", "Анна", "Дарья", "Яна", "Ольга", "Ирина", "Светлана",
                   "Юлия", "Галина", "Евгения", "Алина", "Валентина", "Зинаида", "Карина", "Полина",
                   "София", "Татьяна", "Эльвира", "Алиса", "Василиса", "Жанна", "Инна", "Маргарита",
                   "Надежда", "Рита", "Тамара", "Элеонора", "Ярослава"
    );
  }

  private static List<String> initMaleLastnames() {
    return List.of("Андреев", "Астахов", "Барсуков", "Безруков", "Винокуров", "Воронин",
                   "Герасимов", "Гусев", "Давыдов", "Денисов", "Евдокимов", "Ермаков", "Жданов",
                   "Жуков", "Зайцев", "Золотов", "Иванов", "Игнатьев", "Калинин", "Комаров",
                   "Лавров", "Лобанов", "Макаров", "Морозов", "Никитин", "Новиков", "Орлов",
                   "Петров", "Попов", "Романов", "Рыжов", "Савельев", "Смирнов", "Титов",
                   "Туманов", "Уткин", "Фёдоров", "Фролов", "Хомяков", "Царёв", "Черных", "Шишкин",
                   "Яковлев"
    );
  }

  private static List<String> initFemaleLastnames() {
    return List.of("Андреева", "Астахова", "Барсукова", "Безрукова", "Винокурова",
                   "Воронина", "Герасимова", "Гусева", "Давыдова", "Денисова", "Евдокимова",
                   "Ермакова", "Жданова", "Жукова", "Зайцева", "Золотова", "Иванова", "Игнатьева",
                   "Калинина", "Комарова", "Лаврова", "Лобанова", "Макарова", "Морозова",
                   "Никитина", "Новикова", "Орлова", "Петрова", "Попова", "Романова", "Рыжова",
                   "Савельева", "Смирнова", "Титова", "Туманова", "Уткина", "Фёдорова", "Фролова",
                   "Хомякова", "Царёва", "Черных", "Шишкина", "Яковлева"
    );
  }

}
