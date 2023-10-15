package core.two.lesson9;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.OptionalDouble;

public class Student {

  private final String firstname;
  private final String lastname;
  private int course;
  private final List<Integer> grades = new ArrayList<>();

  public Student(String firstname, String lastname, int course) {
    this.firstname = firstname;
    this.lastname = lastname;
    this.course = course;
  }

  public Student(String firstname, String lastname, int course, Collection<Integer> grades) {
    this(firstname, lastname, course);
    this.grades.addAll(grades);
  }

  public String getFullName() {
    return String.join(" ", firstname, lastname);
  }

  public String getFirstname() {
    return firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public int getCourse() {
    return course;
  }

  public void setCourse(int course) {
    this.course = course;
  }

  public List<Integer> getGrades() {
    return new ArrayList<>(grades);
  }

  public void addGrade(Integer grade) {
    grades.add(grade);
  }

  public void addAllGrades(Collection<Integer> gradesToAdd) {
    grades.addAll(gradesToAdd);
  }

  public Double getAverageGrade() {
    OptionalDouble average = grades.stream()
        .mapToInt(g -> g)
        .average();
    return average.isPresent() ? average.getAsDouble() : 0;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Student student = (Student) o;
    return course == student.course &&
           Objects.equals(firstname, student.firstname) &&
           Objects.equals(lastname, student.lastname) &&
           Objects.equals(grades, student.grades);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstname, lastname, course, grades);
  }

  @Override
  public String toString() {
    return "Student{" +
           "firstname='" + firstname + '\'' +
           ", lastname='" + lastname + '\'' +
           ", course=" + course +
           ", grades=" + grades +
           '}';
  }
}
