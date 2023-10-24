package core.two.lesson9;

import static core.two.lesson9.ReportUtil.*;

import core.two.lesson9.model.Student;
import java.util.List;
import java.util.Map;

/**
 * Задание 1 Дан список студентов с полями: - Имя - Фамилия - Номер курса в университете - Список
 * оценок за учебу Преобразовать этот список студентов в ассоциативный массив, где ключом является
 * номер курса, а значением:
 * -
 * Средняя оценка студентов этого курса, количество оценок у которых больше 3-х
 * -
 * Список студентов данного курса, но только с полями Имя и Фамилия. Список должен быть
 * отсортированы по этим двум полям
 * -
 * Объект с двумя полями:
 * - Отсортированный список студентов с пункта 2
 * - Средняя оценка этих студентов
 */
public class Demo {

  private static final int MARKS_COUNT = 3;

  public static void main(String[] args) {
    // средняя оценка студентов по всем курсам
    printAverageGradeOnCourse(MARKS_COUNT, getStudents());

    // отсортированный список имён студентов по всем курсам
    Map<Integer, List<String>> courseAndStudentNames = coursesAndSortedStudentLists(getStudents());
    printStudentsOnCourse(courseAndStudentNames);

    // отсортированный список имён студентов и их средний балл по всем курсам
    printStudentOnCourseAndAverageGrade(courseAndStudentNames, getStudents());
  }

  private static List<Student> getStudents() {
    return List.of(
        new Student("Galya", "Ivanova", 1, List.of(4, 5, 4, 4, 4)),
        new Student("Sergey", "Makarov", 1, List.of(3, 5, 3, 4)),
        new Student("Olga", "Stepanova", 2, List.of(4, 5, 4, 3, 5)),
        new Student("Maksim", "Vetrov", 2, List.of(5, 5, 4, 4, 3)),
        new Student("Lisa", "Belkina", 3, List.of(5, 5, 5, 5)),
        new Student("Egor", "Solovev", 3, List.of(3, 3, 3)),
        new Student("Maria", "Sokolova", 4, List.of(3, 5, 4, 3)),
        new Student("Nikita", "Tarasov", 4, List.of(4, 5, 3, 4)),
        new Student("Arsenij", "Petrov", 5, List.of(4, 3, 3, 4, 5)),
        new Student("Vera", "Sidorova", 5, List.of(3, 3, 5, 5, 4))
    );
  }
}
