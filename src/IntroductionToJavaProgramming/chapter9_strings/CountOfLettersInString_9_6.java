package IntroductionToJavaProgramming.chapter9_strings;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class CountOfLettersInString_9_6 {

    public static void getCountOfLetterInString() {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter string
        System.out.print("Enter string to count letters: ");
        String str = input.nextLine();

        int[] count = getLetterCount(str.toLowerCase());

        //display result
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0)
                System.out.println((char) ('a' + i) + " founded " + count[i] + (count[i] == 1 ? " time" : " times"));
        }
    }

    private static int[] getLetterCount(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                count[s.charAt(i) - 'a']++;

        return count;
    }
}
