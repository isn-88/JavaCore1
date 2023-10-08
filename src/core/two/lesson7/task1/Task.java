package core.two.lesson7.task1;

import core.two.lesson7.task1.comparator.ChatCountComparator;
import core.two.lesson7.task1.comparator.ChatNameComparator;
import core.two.lesson7.task1.entity.Chat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Задание 1
 * Дан список чатов.
 * Каждый чат состоит из двух полей: название и количество пользователей в этом чате.
 * Задача:
 * - Удалить с помощью итератора из этого списка те чаты, что содержат менее 1000 пользователей.
 * - Оставшиеся чаты отсортировать с помощью компараторов по убыванию по количеству
 * пользователей, а если это количество совпадает, то по названию в алфавитном порядке.
 * - Также предоставить сортировку чатов по названию по умолчанию.
 */
public class Task {

  private static final List<Chat> CHATS = new ArrayList<>();

  static {
    CHATS.add(new Chat("DMdev", 1500));
    CHATS.add(new Chat("Books", 999));
    CHATS.add(new Chat("SQL for beginners", 1250));
    CHATS.add(new Chat("Live codding", 1120));
    CHATS.add(new Chat("Learn Java", 1120));
    CHATS.add(new Chat("Soft skills", 820));
    CHATS.add(new Chat("DevOps every day", 450));
    CHATS.add(new Chat("Time to AI", 690));
  }

  public static void main(String[] args) {
    Task task = new Task();

    List<Chat> chats = task.getChats();
    System.out.println("Исходный список:\n" + chats);
    task.removeIfCountLower(1000, chats);
    System.out.println("После удаления:\n" + chats);
    chats.sort(new ChatCountComparator().thenComparing(new ChatNameComparator()));
    System.out.println("После сортировки:\n" + chats);

    chats = task.getChats();
    System.out.println("\nИсходный список:\n" + chats);
    task.sortByName(chats);
    System.out.println("После сортировки по имени:\n" + chats);
  }


  public void removeIfCountLower(int count, List<Chat> chats) {
    Iterator<Chat> chatIterator = chats.iterator();
    while (chatIterator.hasNext()) {
      Chat chat = chatIterator.next();
      if (chat.getCount() < count) {
        chatIterator.remove();
      }
    }
  }

  public void sortByName(List<Chat> chats) {
    chats.sort(new ChatNameComparator());
  }

  public List<Chat> getChats() {
    return new ArrayList<>(CHATS);
  }
}
