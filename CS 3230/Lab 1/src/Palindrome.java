import java.util.Scanner;
import java.lang.StringBuilder;

/**
 * Author: Daniel Silva
 * CS 3230
 * Lab 1
 */
public class Palindrome {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        System.out.println("java palindrome\nPlease enter a potential palindrome:");
        String palindrome = input.nextLine();
        isPalindrome(sb, palindrome);
    }

    /**
     * @param sb         String Builder object to create new String
     * @param palindrome word of type String to test if it's a palindrome.
     */
    private static void isPalindrome(StringBuilder sb, String palindrome) {
        String singleWord = palindrome.replaceAll("\\s", "");
        int first = 0;
        for (int i = singleWord.length() - 1; i >= 0; i--) {
            if (singleWord.charAt(first) == singleWord.charAt(i)) {
                sb.append(singleWord.charAt(i));
                first++;
            } else {
                System.out.println("Word is NOT a palindrome!");
                System.exit(1);
            }
        }
        String newString = new String(sb);
        if (singleWord.equals(newString))
            System.out.print("Word IS a palindrome.");
    }

}
