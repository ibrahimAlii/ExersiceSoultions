package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class HexToDecimal {

    public static void hexToDecimal(){

        Scanner input = new Scanner(System.in);

        //prompt the user to enter a string
        System.out.print("Enter the hex to convert to decimal: ");
        String hex = input.nextLine();

        System.out.println("The decimal value for " + hex + " is " + hexToDecimal(hex));
    }

    private static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for (int i = 0; i < hex.length(); i++) {
            char hexChar = hex.charAt(i);
            decimalValue = decimalValue * 16 + hexCharToDecimal(hexChar);
        }
        return decimalValue;
    }

    private static int hexCharToDecimal(char character) {
        if (character >= 'A' && character <= 'F')
            return 10 + character - 'A';
        else //character is '0', '1',....,'9'
            return character - '0';
    }
}
