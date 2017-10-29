package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class ConsecutiveFour_6_30 {

    public static void checkConsecutive(){

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the list size: ");
        int size = scanner.nextInt();
        int[] list = new int[size];
        System.out.println("Enter numbers");
        for (int i = 0; i < size; i++)
            list[i] = scanner.nextInt();


        System.out.println((isConsecutiveFour(list) ? "List contain consecutive numbers" : "List doesn't contain consecutive numbers"));

    }

    private static boolean isConsecutiveFour(int[] values){

        if (values.length < 4)
            return false;

        int value = values[0];
        int consecutiveCount = 1;
        for (int i = 0; i < values.length - 1; i++) {
            if (values[i] != value && values[i] == values[i + 1]){
                value = values[i];
                consecutiveCount = 1;
            }


            if (value == values[i])
                consecutiveCount++;
        }

        return consecutiveCount >= 4;
    }
}
