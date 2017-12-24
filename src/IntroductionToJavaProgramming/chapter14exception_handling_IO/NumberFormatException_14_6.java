package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.lang.NumberFormatException;
import java.util.Scanner;

public class NumberFormatException_14_6 {

    public static void numberFormatException() {


        Scanner input = new Scanner(System.in);

        String str = input.nextLine();

        System.out.println(hexToDecimal(str));

    }

    private static int hexToDecimal(String str) {

        int decimal = 0;
        for (int i = 0; i < str.length(); i++) {

            if (!(str.charAt(i) >= '0' && str.charAt(i) <= '9') ||
                    !(str.charAt(i) >= 'A' && str.charAt(i) <= 'F'))
                throw new NumberFormatException("Not a Hex !");
            else
                decimal = decimal * 16 + hexCharToDecimal(str.charAt(i));
        }
        return decimal;
    }

    private static int hexCharToDecimal(char c) {
        if (c >= 'A' && c <= 'F')
            return 10 + c - 'A';
        else return c - '0';
    }

}
