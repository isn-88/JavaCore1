package core.two.lesson7.task1.util;

import core.two.lesson7.task1.comparator.ChatNameComparator;
import core.two.lesson7.task1.entity.Chat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ChatUtil {

  private ChatUtil() {
  }

  public static List<Chat> getAllChats() {
    List<Chat> chats = new ArrayList<>();
    chats.add(new Chat("DMdev", 1500));
    chats.add(new Chat("Books", 999));
    chats.add(new Chat("SQL for beginners", 1250));
    chats.add(new Chat("Live codding", 1120));
    chats.add(new Chat("Learn Java", 1120));
    chats.add(new Chat("Soft skills", 820));
    chats.add(new Chat("DevOps every day", 450));
    chats.add(new Chat("Time to AI", 690));
    return chats;
  }

  public static void removeIfCountLower(int count, List<Chat> chats) {
    Iterator<Chat> chatIterator = chats.iterator();
    while (chatIterator.hasNext()) {
      Chat chat = chatIterator.next();
      if (chat.getCount() < count) {
        chatIterator.remove();
      }
    }
  }

  public static void sortByName(List<Chat> chats) {
    chats.sort(new ChatNameComparator());
  }
}
