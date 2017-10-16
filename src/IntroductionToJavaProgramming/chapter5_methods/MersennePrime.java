package IntroductionToJavaProgramming.chapter5_methods;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.util.Scanner;

public class MersennePrime {

    private static int REQUIRED_NUMBERS;

    public static void getMersennePrimes() {
        REQUIRED_NUMBERS = 31;

        System.out.println("\np           2^p-1");
        System.out.println("--------------------");
        for (int p = 2; p <= REQUIRED_NUMBERS; p++) {
            if (PrimeNumbers.isPrime(p)){
                System.out.printf("%-13d", p);
                System.out.println(getMersenne(p));
            }
        }

    }

    public static int getMersenne(int num) {

        return (int) Math.pow(2, num) - 1;

    }
}
