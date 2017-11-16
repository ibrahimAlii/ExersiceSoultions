package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class PhoneKeypads_9_7 {

    public static void getNumber(){

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter a string with letter
        System.out.print("Enter the string: ");
        String str = input.nextLine();

        String result = getNumber(str.toUpperCase());

        //Display result
        System.out.println(result);
    }

    private static String getNumber(String s) {

        String result = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'A' || s.charAt(i) == 'B' || s.charAt(i) == 'C')
                result += "2";
            else if (s.charAt(i) == 'D' || s.charAt(i) == 'E' || s.charAt(i) == 'F')
                result += "3";
            else if (s.charAt(i) == 'G' || s.charAt(i) == 'H' || s.charAt(i) == 'I')
                result += "4";
            else if (s.charAt(i) == 'J' || s.charAt(i) == 'K' || s.charAt(i) == 'L')
                result += "5";
            else if (s.charAt(i) == 'M' || s.charAt(i) == 'N' || s.charAt(i) == 'O')
                result += "6";
            else if (s.charAt(i) == 'P' || s.charAt(i) == 'Q' || s.charAt(i) == 'R' || s.charAt(i) == 'S')
                result += "7";
            else if (s.charAt(i) == 'T' || s.charAt(i) == 'U' || s.charAt(i) == 'V')
                result += "8";
            else if (s.charAt(i) == 'W' || s.charAt(i) == 'X' || s.charAt(i) == 'Y' || s.charAt(i) == 'Z')
                result += "9";
            else
                result += s.charAt(i);
        }

        return result;
    }
}
