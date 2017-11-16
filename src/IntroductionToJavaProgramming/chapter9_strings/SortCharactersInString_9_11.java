package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class SortCharactersInString_9_11 {

    public static void sortCharactersInString() {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter string to sort it
        System.out.print("Enter String: ");
        String str = input.nextLine();

        //Display result
        System.out.println(sort(str));
    }

    private static String sort(String str) {

        StringBuilder stringBuilder = new StringBuilder(str);
        for (int i = 0; i < stringBuilder.length() -1; i++) {
            char currentMinChar = stringBuilder.charAt(i);
            int currentMinIndex = i;
            for (int j = i + 1; j < stringBuilder.length(); j++) {
                if (currentMinChar > stringBuilder.charAt(j)){
                    currentMinChar = stringBuilder.charAt(j);
                    currentMinIndex = j ;
                }
            }
            if (currentMinIndex != i){
                stringBuilder.setCharAt(currentMinIndex, stringBuilder.charAt(i));
                stringBuilder.setCharAt(i, currentMinChar);

            }

        }
        return stringBuilder.toString();
    }
}
