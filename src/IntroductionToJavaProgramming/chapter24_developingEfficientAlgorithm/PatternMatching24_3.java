package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm;

import java.util.Scanner;

public class PatternMatching24_3 {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String s1 = input.nextLine();

        String s2 = input.nextLine();

        checkForPatterent(s1, s2);
    }

    private static void checkForPatterent(String s1, String s2) {
        int index = s2.length();
        int k = 0;
        int startIndex = 0;
        boolean isFoundKeyBefore = false;

        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == s2.charAt(k)) {
                k++;
                index--;

                if (!isFoundKeyBefore) {
                    startIndex = i;
                    isFoundKeyBefore = true;
                }

            } else {
                k = 0;
                index = s2.length();
                isFoundKeyBefore = false;
            }

            if (index == 0) {
                System.out.println("Matched at index " + (startIndex));
                break;
            }
        }
    }
}
