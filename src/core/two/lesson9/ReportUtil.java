package core.two.lesson9;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ReportUtil {

  private ReportUtil() {
  }

  public static Map<Integer, Double> toMapAverageGradeOnCourse(List<Student> students) {
    return students.stream()
        .filter(s -> s.getGrades().size() > 3)
        .collect(toMap(
            Student::getCourse,
            Student::getAverageGrade,
            (s1, s2) -> (s1 + s2) / 2
        ));
  }

  public static Map<Integer, List<String>> toMapStudentsOnCourse(List<Student> students) {
    return students.stream()
        .sorted(Comparator.comparing(Student::getFullName))
        .collect(groupingBy(
            Student::getCourse,
            mapping(Student::getFullName, toList())
        ));
  }

  public static Map<Integer, Report> toMapStudentOnCourseAndAverageGrade(List<Student> students) {
    return students.stream()
        .sorted(Comparator.comparing(Student::getFullName))
        .collect(toMap(
            Student::getCourse,
            s -> new Report(s.getFullName(), s.getAverageGrade()),
            Report::merge
        ));
  }

  public static void printAverageGradeOnCourse(List<Student> students) {
    Map<Integer, Double> result = toMapAverageGradeOnCourse(students);
    System.out.println("Общая успеваемость всех студентов у которых более 3х оценок:");
    for (Entry<Integer, Double> entry : result.entrySet()) {
      System.out.println(String.join(
          " ","Курс:", entry.getKey().toString(),
          "средний балл:", entry.getValue().toString()
      ));
    }
  }

  public static void printStudentsOnCourse(List<Student> students) {
    System.out.println("Списки студентов по курсам:");
    Map<Integer, List<String>> result = toMapStudentsOnCourse(students);
    for (Entry<Integer, List<String>> entry : result.entrySet()) {
      System.out.println(String.join(
          " ", "Курс:", entry.getKey().toString(),
          "студенты:", entry.getValue().toString()
      ));
    }
  }

  public static void printStudentOnCourseAndAverageGrade(List<Student> students) {
    System.out.println("Список студентов по курсам и их средний балл:");
    Map<Integer, Report> result = toMapStudentOnCourseAndAverageGrade(students);
    for (Entry<Integer, Report> entry : result.entrySet()) {
      System.out.println(String.join(
          " ", "Курс:", entry.getKey().toString(),
          "студенты:",  entry.getValue().getNames().toString(),
          "средний балл:", String.valueOf(entry.getValue().getAverageGrade())
      ));
    }
  }
}
