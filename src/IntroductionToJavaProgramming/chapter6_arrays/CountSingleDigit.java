package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class CountSingleDigit {

    public static void countSingleDigit(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the amount of random digits e.g 5,6,7");
        int amountOfRandom = scanner.nextInt();
        System.out.println("Enter amount of repeat e.g 100,150");
        int repeatCounts = scanner.nextInt();
        int[] counts = new int[amountOfRandom];

        for (int i = 0; i < repeatCounts; i++) {
            counts[(int) (Math.random() * amountOfRandom)]++;
            System.out.print(" " + counts[(int) (Math.random() * amountOfRandom)]++);
        }

        for (int i = 0; i < counts.length; i++) {
            System.out.println("\ncount of " + i + " is " + counts[i]);
        }

    }

}
