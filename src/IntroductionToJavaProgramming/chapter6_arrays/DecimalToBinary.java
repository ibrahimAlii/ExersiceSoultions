package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class DecimalToBinary {

    public static void decimalToBinary(){

        System.out.print("Enter a number: ");
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        System.out.println(Integer.toBinaryString(number));
    }
}
