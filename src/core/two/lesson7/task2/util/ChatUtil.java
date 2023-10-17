package core.two.lesson7.task2.util;

import core.two.lesson7.task2.entity.Chat;
import core.two.lesson7.task2.entity.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public final class ChatUtil {

  private ChatUtil() {
  }

  public static List<Chat> getAllChats() {
    List<Chat> chats = new ArrayList<>();
    chats.add(new Chat("DMdev", UserUtil.getRandomUsers()));
    chats.add(new Chat("Books", UserUtil.getRandomUsers()));
    chats.add(new Chat("SQL for beginners", UserUtil.getRandomUsers()));
    chats.add(new Chat("Live codding", UserUtil.getRandomUsers()));
    chats.add(new Chat("Learn Java", UserUtil.getRandomUsers()));
    chats.add(new Chat("Soft skills", UserUtil.getRandomUsers()));
    chats.add(new Chat("DevOps every day", UserUtil.getRandomUsers()));
    chats.add(new Chat("Time to AI", UserUtil.getRandomUsers()));
    return chats;
  }

  public static List<User> getAllUsersFromChats(int minAge, List<Chat> chats) {
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
}
