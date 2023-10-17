package core.two.lesson7.task1.entity;

import java.util.Objects;

public class Chat {

  private final String name;
  private int count;

  public Chat(String name, int count) {
    this.name = name;
    this.count = count;
  }

  public Chat(String name) {
    this(name, 0);
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
    return count == chat.count && Objects.equals(name, chat.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, count);
  }

  @Override
  public String toString() {
    return "Chat{" +
           "name='" + name + '\'' +
           ", subscribers=" + count +
           '}';
  }

  public String getName() {
    return name;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
