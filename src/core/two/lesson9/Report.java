package core.two.lesson9;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Report {

  private final List<String> names;
  private double averageGrade;

  public Report(List<String> names, double averageGrade) {
    this.names = names;
    this.averageGrade = averageGrade;
  }

  public Report(String name, double averageGrade) {
    this.names = new ArrayList<>(List.of(name));
    this.averageGrade = averageGrade;
  }

  public List<String> getNames() {
    return names;
  }

  public double getAverageGrade() {
    return averageGrade;
  }

  public void updateAverageGrade(double averageGrade) {
    this.averageGrade = (getAverageGrade() + averageGrade) / 2;
  }

  public Report merge(Report report) {
    names.addAll(report.names);
    updateAverageGrade(report.averageGrade);
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Report report = (Report) o;
    return Double.compare(averageGrade, report.averageGrade) == 0 &&
           Objects.equals(names, report.names);
  }

  @Override
  public int hashCode() {
    return Objects.hash(names, averageGrade);
  }

  @Override
  public String toString() {
    return "Report{" +
           "names=" + names +
           ", averageGrade=" + averageGrade +
           '}';
  }
}
