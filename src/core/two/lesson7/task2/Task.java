package core.two.lesson7.task2;

import core.two.lesson7.task2.entity.Chat;
import core.two.lesson7.task2.entity.User;
import core.two.lesson7.task2.util.ChatUtil;
import core.two.lesson7.task2.util.UserUtil;
import java.util.List;

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

  public static void main(String[] args) {
    List<Chat> chats = ChatUtil.getAllChats();
    System.out.println("Исходный список чатов:\n" + chats);

    List<User> users = ChatUtil.getAllUsersFromChats(18, chats);
    System.out.println("\nСписок всех пользователей:\n" + users);

    int avgAge = UserUtil.userAvgAge(users);
    System.out.println("\nСредний возраст пользователей старше 18 лет: " + avgAge);
  }
}
