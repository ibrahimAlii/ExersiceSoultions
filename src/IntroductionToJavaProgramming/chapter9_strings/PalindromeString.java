package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class PalindromeString {

    public static void checkPalindrome() {

        Scanner input = new Scanner(System.in);

        //receive input from user
        System.out.println("Enter the string");
        String data = input.nextLine();

        //check palindromaty
        if (isPalindrome(data))
            System.out.println(data + " Is palindrome");
        else
            System.out.println(data + " Is not");
    }

    private static boolean isPalindrome(String data) {

        int low = 0; //define first character
        int high = data.length() - 1; //define highest character

        while (low < high) {
            if (data.charAt(low) != data.charAt(high))
                return false;  //that's mean it's not palindrome

            low++;
            high--;
        }

        return true; //true it's palindrome

    }
}
