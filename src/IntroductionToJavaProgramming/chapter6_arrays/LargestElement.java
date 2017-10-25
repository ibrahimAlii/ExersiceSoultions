package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class LargestElement {

    public static void getLargestElement(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("How much number you wanna test?");
        int cases = scanner.nextInt();

        double[] arr = new double[cases];

        for (int i = 0; i < cases; i++) {
            arr[i] = scanner.nextDouble();
        }

        System.out.println(max(arr));

    }

    private static double max(double[] array){

        double maxVal = 0;
        for (double anArray : array) {
            if (anArray > maxVal)
                maxVal = anArray;
        }

        return maxVal;
    }
}
