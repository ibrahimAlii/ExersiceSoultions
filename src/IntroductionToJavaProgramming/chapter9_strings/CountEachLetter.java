package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class CountEachLetter {

    public static void countLetters() {

        Scanner input = new Scanner(System.in);

        //prompt the user to enter a string
        System.out.print("Enter a string: ");
        String s = input.nextLine();

        //Invoke the count method to count each letter
        int[] counts = countLetters(s.toLowerCase());

        for (int i = 0; i < counts.length; i++) {
            if (counts[i] != 0)
                System.out.println((char)('a' + i) + " appears " +
                counts[i] + ((counts[i] == 1 ? " time" : " times")));
        }
    }

    private static int[] countLetters(String s) {
        int[] counts = new int[26];

        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)))
                counts[s.charAt(i) - 'a']++;
        }

        return counts;
    }
}
