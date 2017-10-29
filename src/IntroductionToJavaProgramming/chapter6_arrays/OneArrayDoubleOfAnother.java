package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class OneArrayDoubleOfAnother {

    public static void checkDouble(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the two list size: ");
        int size = scanner.nextInt();
        int[]list1 = new int[size];
        int[]list2 = new int[size];

        System.out.print("Enter First list numbers: ");
        for (int i = 0; i < size; i++) {
            list1[i] = scanner.nextInt();
        }
        System.out.print("Enter Second list numbers: ");
        for (int i = 0; i < size; i++) {
            list2[i] = scanner.nextInt();
        }

        System.out.println((isDouble(list1, list2) ? "Second list is double of first list" : "Second list is not double of first list"));
    }

    private static boolean isDouble(int[] list1, int[] list2){

        for (int i = 0; i < list1.length; i++) {
            if (list2[i] == list1[i] * 2)
                return true;
        }
        return false;
    }
}
