package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;


public class BinaryToHex_9_4 {

    public static void binaryToHex() {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter binary value
        System.out.print("Enter binary value: ");
        String binaryValue = input.nextLine();

        String hexValue = binaryToHex(binaryValue);

        //Display result
        System.out.println(hexValue);
    }

    private static String binaryToHex(String binary) {
        int decimalValue = 0;
        int length = binary.length() - 1;
        for (int i = 0; i < binary.length(); i++) {
            decimalValue += Integer.parseInt(binary.charAt(i) + "") * Math.pow(2, length);
            length--;
        }
        return decimalToHex(decimalValue);
    }
    private static String decimalToHex(int decimal){
        String hex = "";
        while (decimal != 0){
            int hexValue = decimal % 16;
            hex = toHexChar(hexValue) + hex;
            decimal = decimal / 16;
        }
        return hex;
    }

    private static char toHexChar(int hexValue) {
        if (hexValue <= 9 && hexValue >= 0)
            return (char)(hexValue + '0');
        else
            return (char)(hexValue - 10 + 'A');
    }
}
