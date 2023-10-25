package core.two.lesson9;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toMap;

import core.two.lesson9.model.Report;
import core.two.lesson9.model.Student;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public final class ReportUtil {

  private ReportUtil() {
  }

  /**
   * Вычисляет средний балл студентов на каждом курсе
   * с учётом фильтрации студентов с минимальным количеством оценок
   */
  public static Map<Integer, Double> courseAndAverageGrade(int minMarksCount,
                                                           List<Student> students) {
    return students.stream()
        .filter(s -> s.getGrades().size() > minMarksCount)
        .collect(Collectors.groupingBy(
            Student::getCourse,
            Collectors.averagingDouble(Student::getAverageGrade)
        ));
  }

  /**
   * Принимает на вход список студентов и сохраняет в Map,
   * где ключом является курс студента,
   * а значением отсортированный список имён и фамилий студентов
   */
  public static Map<Integer, List<String>> coursesAndSortedStudentLists(List<Student> students) {
    return students.stream()
        .sorted(Comparator.comparing(Student::getFullName))
        .collect(groupingBy(Student::getCourse, mapping(Student::getFullName, toList())));
  }

  /**
   * Принимает на вход отсортированный список имён студентов по курсам
   * и полный список студентов
   * Возвращает отсортированный списко имён студентов и их средний бал по всем курсам
   */
  public static Map<Integer, Report> courseAndStudentNamesWithAverageGrade(
      Map<Integer, List<String>> sortedStudentList,
      List<Student> students) {
    return sortedStudentList.entrySet().stream()
        .map(entry -> Map.entry(
            entry.getKey(),
            new Report(
                entry.getValue(),
                students.stream()
                    .filter(s -> s.getCourse() == entry.getKey())
                    .mapToDouble(Student::getAverageGrade)
                    .average().orElse(0.0)
            )))
        .collect(toMap(Entry::getKey,Entry::getValue));
  }

  public static void printAverageGradeOnCourse(int minMarksCount, List<Student> students) {
    Map<Integer, Double> result = courseAndAverageGrade(minMarksCount, students);
    System.out.printf("\nОбщая успеваемость всех студентов у которых более %d оценок:\n",
                      minMarksCount);
    for (Entry<Integer, Double> entry : result.entrySet()) {
      System.out.println(String.join(
          " ","Курс:", entry.getKey().toString(),
          "средний балл:", entry.getValue().toString()
      ));
    }
  }

  public static void printStudentsOnCourse(Map<Integer, List<String>> students) {

    System.out.println("\nСписки студентов по курсам:");
    for (Entry<Integer, List<String>> entry : students.entrySet()) {
      System.out.println(String.join(
          " ", "Курс:", entry.getKey().toString(),
          "студенты:", entry.getValue().toString()
      ));
    }
  }

  public static void printStudentOnCourseAndAverageGrade(
      Map<Integer, List<String>> sortedStudentList,
      List<Student> students) {
    System.out.println("\nСписок студентов по курсам и их средний балл:");
    Map<Integer, Report> result =
        courseAndStudentNamesWithAverageGrade(sortedStudentList, students);
    for (Entry<Integer, Report> entry : result.entrySet()) {
      System.out.println(String.join(
          " ", "Курс:", entry.getKey().toString(),
          "студенты:",  entry.getValue().getNames().toString(),
          "средний балл:", String.valueOf(entry.getValue().getAverageGrade())
      ));
    }
  }
}
