package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class KeyElementSearch {

    public static void elementSearch(){

        System.out.println("Enter six numbers(in ascending order):");
        Scanner scanner = new Scanner(System.in);
        int[] arrNumbers = new int[6];
        for (int i = 0; i < 6; i++) {
            arrNumbers[i] = scanner.nextInt();
        }

        System.out.println("Enter a number to read");
        int key = scanner.nextInt();
        System.out.println("Element is found at " + LinearSearch.linearSearch(arrNumbers, key) + " position");
    }
}
