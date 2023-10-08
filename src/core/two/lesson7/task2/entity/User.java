package core.two.lesson7.task2.entity;

import java.util.Objects;


public class User {

  private final int id;
  private final String name;
  private int age;

  public User(int id, String name, int age) {
    this.id = id;
    this.name = name;
    this.age = age;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    User user = (User) o;
    return id == user.id && age == user.age && Objects.equals(name, user.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, age);
  }

  @Override
  public String toString() {
    return "User{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", age=" + age +
           '}';
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }
}
