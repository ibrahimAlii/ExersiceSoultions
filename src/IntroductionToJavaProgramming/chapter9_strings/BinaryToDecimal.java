package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class BinaryToDecimal {

    public static void binaryToDecimal() {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter the binary number
        System.out.print("Enter the binary number: ");
        String binaryNumber = input.nextLine();

        int decimalNum = binaryToDecimal(binaryNumber);

        System.out.println(decimalNum);

    }

    private static int binaryToDecimal(String binaryNumber) {
        int decimalNumber = 0;
        int length = binaryNumber.length() - 1;
        for (int i = 0; i < binaryNumber.length(); i++) {
            if (Character.isDigit(binaryNumber.charAt(i)))
                if (length > 0)
                    decimalNumber += Integer.parseInt(String.valueOf(binaryNumber.charAt(i))) * (Math.pow(2, length));
                else
                    decimalNumber += Integer.parseInt(String.valueOf(binaryNumber.charAt(i)));

            length--;
        }
        return decimalNumber;
    }
}
