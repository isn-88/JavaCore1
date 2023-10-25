package core.two.lesson10.model;

import java.util.Objects;

public class Item implements Comparable<Item> {

  private final Integer id;
  private final String name;
  private final Double price;

  public Item(Integer id, String name, Double price) {
    this.id = id;
    this.name = name;
    this.price = price;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public Double getPrice() {
    return price;
  }

  public String toCsv() {
    return String.join(
        ",",
        Objects.toString(id, ""),
        Objects.toString(name, ""),
        Objects.toString(price, "")
    );
  }

  @Override
  public int compareTo(Item o) {
    return Integer.compare(id, o.getId());
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Item item = (Item) o;
    return Objects.equals(id, item.id) &&
           Objects.equals(name, item.name) &&
           Objects.equals(price, item.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, price);
  }

  @Override
  public String toString() {
    return "Item{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", price=" + price +
           '}';
  }
}


