package IntroductionToJavaProgramming.chapter9_strings;

import IntroductionToJavaProgramming.chapter7_twoDeimensionalArray.GuessCapitals_7_37;

import java.util.Scanner;

public class GuessTheCapitals_9_17 {

    public static void guessTheCapitals(){

        Scanner input = new Scanner(System.in);

        String[][] capitals = initArray();
        String answer = "";
        //Ask the question
        int score = 0;
        for (int i = 0; i < capitals.length; i++) {
            for (int j = 0; j < capitals[i].length - 1; j++) {
                System.out.print("What is the capital of " + capitals[i][0] + " ? ");
                answer = input.nextLine();
                if (answer.equals(capitals[i][1])){
                    System.out.println("Correct answer");
                    score++;
                }else {
                    System.out.println("Correct answer should be " + capitals[i][1]);
                }
            }
        }

        System.out.println("Your score is " + score);
    }

    private static String[][] initArray() {

        return new String[][] {{"Egypt", "Cairo"},
                {"Saudia", "Riyadah"},
                {"Morocoo", "Morocoo"},
                {"Algeria", "Algeria"},
                {"Jordon", "Amman"},
                {"England", "London"},
                {"France", "Paris"},
                {"UAE", "Dubai"}};
    }
}
