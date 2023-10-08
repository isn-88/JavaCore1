package core.two.lesson7.task2.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Chat {

  private final String name;
  private final List<User> users;

  public Chat(String name, List<User> users) {
    this.name = name;
    this.users = users;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Chat chat = (Chat) o;
    return Objects.equals(name, chat.name) && Objects.equals(users, chat.users);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, users);
  }

  @Override
  public String toString() {
    return "Chat{" +
           "name='" + name + '\'' +
           ", users=" + users +
           '}';
  }

  public Chat(String name) {
    this(name, new ArrayList<>());
  }

  public String getName() {
    return name;
  }

  public List<User> getUsers() {
    return users;
  }
}
