package core.two.lesson4;


/**
 * Задача 1
 * Проверить, является ли введённая строка палиндромом,
 * т.е. читается одинаково в обоих направлениях.
 */
public class Practice1 {

    public static void main(String[] args) {
        String text1 = "Комок";
        String text2  = "()()";
        print(text1, isPalindrome(text1));
        print(text2, isPalindrome(text2));
    }

    private static boolean isPalindrome(String text) {
        if (text == null || text.isEmpty()) {
            return false;
        }
        StringBuilder reverse = new StringBuilder(text).reverse();
        return text.equalsIgnoreCase(reverse.toString());
    }

    private static void print(String text, boolean isPalindrome) {
        System.out.printf("%s - это %s.\n", text, isPalindrome ? "палиндром" : "не палиндром");
    }
}
