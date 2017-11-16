package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class DecimalToBinary_9_10 {

    public static void decimalToBinary(){

        Scanner input = new Scanner(System.in);

       int num = input.nextInt();

        getBits(num);
    }
    private static void getBits(int number){

        String bits = "";
        while (number > 0){
            bits = (number & 1) + bits;
            number >>= 1;
        }
        System.out.println("The bits are " + bits);
    }
}
