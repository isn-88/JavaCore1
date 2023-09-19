package core.two.lesson4;


/**
 * Задание 1
 * Дана строка.
 * Удалить из нее все повторяющиеся символы без учета регистра, если они идут друг за другом.
 * Также удалить пробелы. Результат привести к верхнему регистру.
 * Например:
 * "abc Cpddd Dio OsfWw" -> "ABCPDIOSFW"
 */
public class Task1 {

    public static void main(String[] args) {
        String text = "abc Cpddd Dio OsfWw";
        System.out.printf("Исходная строка: %s\n", text);
        String result = getStringWithoutCharDuplicates(text);
        System.out.printf("Результирующая : %s\n", result);
    }

    private static String getStringWithoutCharDuplicates(String text) {
        if (text == null || text.isBlank()) {
            return "";
        }
        StringBuilder builder = new StringBuilder(text.replace(" ", "").toUpperCase());
        for (int i = 0; i < builder.length() - 1;) {
            if (builder.charAt(i) == builder.charAt(i + 1)) {
                builder.deleteCharAt(i + 1);
            } else {
                i++;
            }
        }
        return builder.toString();
    }
}
