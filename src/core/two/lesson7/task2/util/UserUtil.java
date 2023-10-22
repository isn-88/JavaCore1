package core.two.lesson7.task2.util;

import core.two.lesson7.task2.entity.User;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public final class UserUtil {

  private UserUtil() {
  }

  public static List<User> getAllUsers() {
    List<User> users = new ArrayList<>();
    users.add(new User(1, "Sergey", 41));
    users.add(new User(2, "Anna", 37));
    users.add(new User(3, "Nikita", 35));
    users.add(new User(4, "Olga", 33));
    users.add(new User(5, "Nikolay", 26));
    users.add(new User(6, "Masha", 17));
    users.add(new User(7, "Egor", 19));
    users.add(new User(8, "Dasha", 16));
    users.add(new User(9, "Fedor", 18));
    users.add(new User(10, "Elena", 21));
    return users;
  }

  public static List<User> getRandomUsers() {
    Random random = new Random(System.currentTimeMillis());
    List<User> users = UserUtil.getAllUsers();
    Collections.shuffle(users);
    return users.subList(0, random.nextInt(users.size()));
  }

  public static int userAvgAge(List<User> users) {
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
}
