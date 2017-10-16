package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

public class CreditCardNumberValidation {

    public static void checkCreditCard(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter credit card number: ");
        long creditNumber = scanner.nextLong();
        if (isValid(creditNumber))
            System.out.println(creditNumber + "  is valid");
        else
            System.out.println(creditNumber + "  is invalid");

    }

    private static boolean isValid(long creditNumber) {
        System.out.println((sumOfDoubleEventPlace(creditNumber) + sumOfOddPlace(creditNumber)));
        return (sumOfDoubleEventPlace(creditNumber) + sumOfOddPlace(creditNumber)) % 10 == 0;// if divisible by 10 it's valid.

    }

    private static int sumOfOddPlace(long creditNumber) {

        int digit, sum = 0;
        while (creditNumber > 0){
            for (int i = 1; i <= 2; i++) {
                digit = (int) creditNumber % 10;
                if (i == 1){
                    //System.out.println(digit);
                    sum += digit;
                }
                creditNumber = creditNumber / 10;
            }
        }
        return sum;
    }

    private static int sumOfDoubleEventPlace(long creditNumber) {
        int digit, sum = 0, sumOfDigits = 0, subDigit;

        while (creditNumber > 0){
            for (int i = 1; i <= 2; i++) {
                digit = (int) creditNumber % 10;
                subDigit = digit * 2;
                if (i == 2){
                    //System.out.println(digit);
                    if (subDigit >= 10){
                        for (int j = 1; j <= 2 ; j++) {
                           sumOfDigits += subDigit % 10;
                           subDigit = subDigit / 10;
                        }
                        sum += sumOfDigits;
                    }else {
                        sum += subDigit;
                    }

                }
                creditNumber = creditNumber / 10;
            }


        }
        return sum;
    }
}
