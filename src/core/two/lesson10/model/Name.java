package core.two.lesson10.model;

import core.two.lesson10.util.NullableParser;
import java.util.Objects;

public class Name {

  private Integer id;
  private String name;
  private String description;

  public Name(Integer id, String name, String description) {
    this.id = id;
    this.name = name;
    this.description = description;
  }

  public Name(String text) {
    this(text, ",");
  }

  public Name(String text, String delimiter) {
    if (text != null && delimiter != null) {
      String[] values = text.split(delimiter, 3);
      String sId = (values.length > 0) ? values[0] : null;
      name = (values.length > 1) ? values[1] : null;
      description = (values.length > 2) ? values[2] : null;
      id = NullableParser.safeParseToInt(sId);
    }
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Name name1 = (Name) o;
    return Objects.equals(id, name1.id) &&
           Objects.equals(name, name1.name) &&
           Objects.equals(description, name1.description);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, name, description);
  }

  @Override
  public String toString() {
    return "Name{" +
           "id=" + id +
           ", name='" + name + '\'' +
           ", description='" + description + '\'' +
           '}';
  }

}
