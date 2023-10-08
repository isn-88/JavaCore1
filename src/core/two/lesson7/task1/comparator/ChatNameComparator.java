package core.two.lesson7.task1.comparator;

import core.two.lesson7.task1.entity.Chat;
import java.util.Comparator;


public class ChatNameComparator implements Comparator<Chat> {

  @Override
  public int compare(Chat chat1, Chat chat2) {
    return chat1.getName().compareTo(chat2.getName());
  }
}
