package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class AnalyzeScore {

    public static void analyzeScore(){

        System.out.println("Enter all scores (negative numbers end the program)");
        Scanner scanner = new Scanner(System.in);
        int[] scores = new int[100];
        int score = 0, numberOfScores = 0, average = 0, aboveAv = 0, belowAv = 0;

        for (int i = 0; i < 100; i++) {
            score = scanner.nextInt();
            if (score < 0)
                break;

            scores[i] = score;
            average += score;
            numberOfScores++;
        }

        average /= numberOfScores;

        for (int i = 0; i < numberOfScores; i++) {
            if (scores[i] >= average){
                System.out.println("Above average " + scores[i]);
                aboveAv++;
            }else if (scores[i] < average){
                System.out.println("Below average " + scores[i]);
            belowAv++;

            }
        }

        System.out.println("Average" + average);
        System.out.println("Scores above average " + aboveAv);
        System.out.println("Scores below average " + belowAv);

    }
}
