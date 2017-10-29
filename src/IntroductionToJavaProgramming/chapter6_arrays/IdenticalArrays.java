package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class IdenticalArrays {

    public static void checkEqualize() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the two list size: ");
        int size = scanner.nextInt();
        int[] list1 = new int[size];
        int[] list2 = new int[size];

        System.out.print("Enter First list numbers: ");
        for (int i = 0; i < size; i++) {
            list1[i] = scanner.nextInt();
        }
        System.out.print("Enter Second list numbers: ");
        for (int i = 0; i < size; i++) {
            list2[i] = scanner.nextInt();
        }

        sortArray(list1);
        sortArray(list2);

        System.out.println((equal(list1, list2) ? "Two list are identical" : "Two list are not identical"));

    }

    private static void sortArray(int[] list) {

        for (int i = 0; i < list.length - 1; i++) {

            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }

        }

    }

    private static boolean equal(int[] list1, int[] list2) {

        for (int i = 0; i < list1.length; i++) {
            if (list1[i] != list2[i])
                return false;
        }

        return true;
    }
}
