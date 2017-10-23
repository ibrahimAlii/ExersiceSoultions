package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class PrintOddAndEvenIndex {

    public static void printOddAndEven(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("How much numbers?");
        int number = scanner.nextInt();
        System.out.println("Enter numbers: ");
        int[] numbers = new int[number];
        int oddCount = 0, eventCount = 0;
        int[] oddNumbers = new int[number];
        int[] evenNumbers = new int[number];

        for (int i = 0; i < number; i++) {
            numbers[i] = scanner.nextInt();
            if ((numbers[i] % 2) == 0){
                evenNumbers[eventCount] = numbers[i];
                eventCount++;
            }else {
                oddNumbers[oddCount] = numbers[i];
                oddCount++;
            }
        }

        System.out.print("Even index element are ");
        for (int i = 0; i < eventCount; i++) {
            System.out.print(" " + evenNumbers[i]);
        }
        System.out.print("\nOdd index element are ");
        for (int i = 0; i < oddCount; i++) {
            System.out.print(" " + oddNumbers[i]);
        }

    }
}
