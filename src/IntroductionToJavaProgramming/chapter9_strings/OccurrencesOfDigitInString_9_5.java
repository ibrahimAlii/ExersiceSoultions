package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class OccurrencesOfDigitInString_9_5 {

    public static void occurrencesOfEachDigitInString(){

        Scanner input = new Scanner(System.in);

       //Prompt the user to enter string
        System.out.print("Enter the numbers: ");
        String number = input.nextLine();

        int[] count = count(number);

        //Display result
        for (int i = 0; i < count.length; i++) {
            System.out.println(i + " found " + count[i] + " times" );
        }
    }

    private static int[] count(String number) {
        int[] count = new int[10]; //hold 10 digit
        //Get each digit and increment it's index
        for (int i = 0; i < number.length(); i++)
            if (Character.isDigit(number.charAt(i)))
                count[Integer.parseInt(String.valueOf(number.charAt(i)))]++;


        return count;
    }
}
