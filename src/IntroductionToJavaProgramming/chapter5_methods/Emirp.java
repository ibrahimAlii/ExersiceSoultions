package IntroductionToJavaProgramming.chapter5_methods;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/*
// And emirp (prime spelled backward)
 e.g 17 is emirp because 71 is prime too
 */
public class Emirp {

    public static void printEmirp() {
        int NUMBER_OF_REQUiRED = 100;
        int NUMBERS_PER_LINE = 10;
        int count = 0, number = 1;

        while (count < NUMBER_OF_REQUiRED) {
            if (isEmirp(number)) {
                count++;
                if (count % NUMBERS_PER_LINE == 0)
                    System.out.println(number);
                else
                    System.out.print(number + " ");
            }


            number++;
        }
    }

    private static boolean isEmirp(int number) {
        return isPrime(number) && nonPalindromicIsPrime(number);
    }

    private static boolean nonPalindromicIsPrime(int number) {
        int digit;
        int reserved = 0;
        while (number > 0){
            digit = number % 10;
            reserved = (reserved * 10) + digit;
            number = number / 10;
        }

        return isPrime(reserved);
    }

    private static boolean isPrime(int number) {
        for (int divisor = 2; divisor <= number / 2 ; divisor++) {
            if (number % divisor == 0){ // if true number is not prime
                return false;
            }
        }
        return true;
    }
}
