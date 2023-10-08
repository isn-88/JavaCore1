package core.two.lesson7.task1.comparator;

import core.two.lesson7.task1.entity.Chat;
import java.util.Comparator;


public class ChatCountComparator implements Comparator<Chat> {

  @Override
  public int compare(Chat chat1, Chat chat2) {
    return Integer.compare(chat2.getCount(), chat1.getCount());
  }
}
