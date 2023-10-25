package core.two.lesson10.model;

import core.two.lesson10.util.ParserValidator;
import java.util.Objects;

public class Price {

  private Integer id;
  private Double price;

  public Price(int id, double price) {
    this.id = id;
    this.price = price;
  }

  public Price(String text) {
    this(text, ",");
  }

  public Price(String text, String delimiter) {
    if (text != null && delimiter != null) {
      String[] values = text.split(delimiter, 2);
      String sId = (values.length > 0) ? values[0] : null;
      String sPrice = (values.length > 1) ? values[1] : null;
      id = ParserValidator.safeParseToInt(sId);
      price = ParserValidator.safeParseToDouble(sPrice);
    }
  }

  public Integer getId() {
    return id;
  }

  public Double getPrice() {
    return price;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Price price1 = (Price) o;
    return Objects.equals(id, price1.id) && Objects.equals(price, price1.price);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, price);
  }

  @Override
  public String toString() {
    return "Price{" +
           "id=" + id +
           ", price=" + price +
           '}';
  }
}
