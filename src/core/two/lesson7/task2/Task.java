package core.two.lesson7.task2;

import core.two.lesson7.task2.entity.Chat;
import core.two.lesson7.task2.entity.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;


/**
 * Задание 2
 * Дан список чатов с предыдущего задания, только вместо поля “количество пользователей” будет
 * список объектов типа Пользователь, который имеет 3 поля: id (целочисленный идентификатор), имя
 * и возраст.
 * Задача:
 * - Преобразовать список чатов в один список пользователей всех чатов,
 * возраст которых больше 18 лет
 * - С помощью итератора посчитать средний возраст всех оставшихся пользователей.
 */
public class Task {

  private static final List<User> USERS = new ArrayList<>();

  static {
    USERS.add(new User(1, "Sergey", 41));
    USERS.add(new User(2, "Anna", 37));
    USERS.add(new User(3, "Nikita", 35));
    USERS.add(new User(4, "Olga", 33));
    USERS.add(new User(5, "Nikolay", 26));
    USERS.add(new User(6, "Masha", 17));
    USERS.add(new User(7, "Egor", 19));
    USERS.add(new User(8, "Dasha", 16));
    USERS.add(new User(9, "Fedor", 18));
    USERS.add(new User(10, "Elena", 21));
  }

  public static void main(String[] args) {
    Task task = new Task();
    List<Chat> chats = task.getAllChats();
    System.out.println("Исходный список чатов:\n" + chats);

    List<User> users = task.getAllUsersFromChats(18, chats);
    System.out.println("\nСписок всех пользователей:\n" + users);

    int avgAge = task.userAvgAge(users);
    System.out.println("\nСредний возраст пользователей старше 18 лет: " + avgAge);
  }

  public List<User> getAllUsersFromChats(int minAge, List<Chat> chats) {
    Set<User> users = new HashSet<>();
    for (Chat chat : chats) {
      for (User user : chat.getUsers()) {
        if (user.getAge() >= minAge) {
          users.add(user);
        }
      }
    }
    return new ArrayList<>(users);
  }

  public int userAvgAge(List<User> users) {
    int sum = 0;
    int count = 0;
    Iterator<User> iterator = users.iterator();
    while (iterator.hasNext()) {
      User user = iterator.next();
      sum += user.getAge();
      count++;
    }
    return (count > 0) ? sum / count : 0;
  }

  public List<Chat> getAllChats() {
    List<Chat> chats = new ArrayList<>();
    chats.add(new Chat("DMdev", getRandomUsers()));
    chats.add(new Chat("Books", getRandomUsers()));
    chats.add(new Chat("SQL for beginners", getRandomUsers()));
    chats.add(new Chat("Live codding", getRandomUsers()));
    chats.add(new Chat("Learn Java", getRandomUsers()));
    chats.add(new Chat("Soft skills", getRandomUsers()));
    chats.add(new Chat("DevOps every day", getRandomUsers()));
    chats.add(new Chat("Time to AI", getRandomUsers()));
    return chats;
  }

  private List<User> getRandomUsers() {
    Random random = new Random(System.currentTimeMillis());
    Collections.shuffle(USERS);
    return new ArrayList<>(USERS.subList(0, Math.max(random.nextInt(10), USERS.size())));
  }

}
