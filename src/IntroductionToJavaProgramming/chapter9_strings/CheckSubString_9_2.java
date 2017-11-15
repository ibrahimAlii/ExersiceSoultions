package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class CheckSubString_9_2 {

    public static void checkSubString(){

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter sub-string and string
        System.out.print("Enter the sub-string: ");
        String subString = input.nextLine();
        System.out.print("Enter the string: ");
        String string = input.nextLine();

        //Display result
        System.out.println(subString + " is " + (isSubString(subString, string) ? "Sub-String From " : "Not-SubString From ") + string);

    }

    private static boolean isSubString(String subString, String string) {

        final int length = subString.length();
        if (length == 0)
            return true; // Empty string is contained

        final char firstLo = Character.toLowerCase(subString.charAt(0));
        final char firstUp = Character.toUpperCase(subString.charAt(0));

        for (int i = string.length() - length; i >= 0; i--) {
            // Quick check before calling the more expensive regionMatches() method:
            final char ch = string.charAt(i);
            if (ch != firstLo && ch != firstUp)
                continue;

            if (string.regionMatches(true, i, subString, 0, length))
                return true;
        }

        return false;
    }
}
