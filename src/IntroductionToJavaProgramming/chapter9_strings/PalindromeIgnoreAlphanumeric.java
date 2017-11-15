package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class PalindromeIgnoreAlphanumeric {

    public static void palindromeIgnoreAlphaNumeric(){

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        //Display result
        System.out.println("After ignoring alpha numeric the " + s + " is " + ((isPalindrome(s) ? "Palindrome" : "Not Palindrome")));
    }

    private static boolean isPalindrome(String s) {

        //create new string by eliminating nonalphanumeric chars
        String nonAlpha = filter(s);

        //create new string to reverse eliminated nonAlphaNumeric chars
        String reversed = reverse(nonAlpha);

        //check if nonAlpha is equal to reserved chars or not
        return nonAlpha.equals(reversed); //true if it's palindrome string
    }

    private static String reverse(String nonAlpha) {
        //StringBuilder to append reversed nonAlphaNumeric
        StringBuilder stringBuilder = new StringBuilder(nonAlpha);

        return stringBuilder.reverse().toString();
    }

    private static String filter(String s) {
        //StringBuilder to append nonAlphaNumeric to it
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetterOrDigit(s.charAt(i)))
                stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }
}
