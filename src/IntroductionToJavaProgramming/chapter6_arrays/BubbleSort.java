package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(){

        Scanner scanner = new Scanner(System.in);

        double[] list = new double[6];
        for (int i = 0; i < 6; i++) {
            list[i] = scanner.nextDouble();
        }

        bubbleSort(list);

        for (double num :
                list) {
            System.out.print(" " + num);
        }
    }

    private static void bubbleSort(double[] list){
        double temp;
        boolean swapped;

        do {
            swapped = false;
            for (int i = 0; i < list.length - 1; i++) {
                // If a neighboring pair is not in order, swap values
                if (list[i] > list[i + 1]) {
                    temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }
}
