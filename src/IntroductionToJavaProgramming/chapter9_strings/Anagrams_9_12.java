package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class Anagrams_9_12 {

    public static void isAnagrams(){

        Scanner input = new Scanner(System.in);

        //
        System.out.print("Enter first string: ");
        String str1 = input.nextLine();
        System.out.print("Enter second string: ");
        String str2 = input.nextLine();

        System.out.println(isAnagrams(str1, str2));
    }

    private static boolean isAnagrams(String str1, String str2) {
        char[] firstString = str1.toCharArray();
        char[] secString = str2.toCharArray();
        //sort
        sort(firstString);
        sort(secString);
        //check similarity
        return isSimilar(firstString, secString);

    }

    private static boolean isSimilar(char[] firstString, char[] secString) {
        for (int i = 0; i < firstString.length; i++) {
            if (firstString[i] != secString[i])
                return false;
        }
        return true;
    }

    private static void sort(char[] secString) {

        for (int i = 0; i < secString.length - 1; i++) {
            char currentMinChar = secString[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < secString.length; j++) {
                if (currentMinChar > secString[j]){
                    currentMinChar = secString[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                secString[currentMinIndex] = secString[i];
                secString[i] = currentMinChar;
            }
        }
    }
}
