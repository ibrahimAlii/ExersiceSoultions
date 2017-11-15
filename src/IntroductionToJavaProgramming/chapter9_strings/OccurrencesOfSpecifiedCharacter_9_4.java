package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class OccurrencesOfSpecifiedCharacter_9_4 {

    public static void occurrencesOfSpecifiedCharacter() {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter string and character
        System.out.print("Enter the string: ");
        String str = input.nextLine();
        System.out.print("Enter character to find: ");
        char ch = input.next().charAt(0);

        System.out.println(getCount(str, ch));

    }

    private static int getCount(String str, char ch) {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) == ch)
                count++;

        return count;
    }
}
