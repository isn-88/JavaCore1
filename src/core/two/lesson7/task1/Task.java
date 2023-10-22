package core.two.lesson7.task1;

import core.two.lesson7.task1.comparator.ChatCountComparator;
import core.two.lesson7.task1.comparator.ChatNameComparator;
import core.two.lesson7.task1.entity.Chat;
import core.two.lesson7.task1.util.ChatUtil;
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

  public static void main(String[] args) {

    List<Chat> chats = ChatUtil.getAllChats();
    System.out.println("Исходный список:\n" + chats);
    ChatUtil.removeIfCountLower(1000, chats);
    System.out.println("После удаления:\n" + chats);
    chats.sort(new ChatCountComparator().thenComparing(new ChatNameComparator()));
    System.out.println("После сортировки:\n" + chats);

    chats = ChatUtil.getAllChats();
    System.out.println("\nИсходный список:\n" + chats);
    ChatUtil.sortByName(chats);
    System.out.println("После сортировки по имени:\n" + chats);
  }
}
