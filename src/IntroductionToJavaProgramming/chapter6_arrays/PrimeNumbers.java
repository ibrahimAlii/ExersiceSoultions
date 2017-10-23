package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;



public class PrimeNumbers {

    public static void getPrimes(){

        System.out.println("How much primes you need?");
        Scanner scanner = new Scanner(System.in);
        int primesCount = scanner.nextInt();
        int[] primes = new int[primesCount];
        int testNumber = 1;
        int numbersPerLine = 10;

        while (primesCount > 0){
            if (isPrime(testNumber)){
                primesCount--;
                primes[primesCount] = testNumber;
                if (primesCount % numbersPerLine == 0)
                    System.out.println( " " + testNumber);
                else
                    System.out.print(" " + testNumber);
            }
            testNumber++;
        }
    }

    public static boolean isPrime(int number){
        for (int divisor = 2; divisor <= number / 2 ; divisor++) {
             if (number % divisor == 0){
                 return false;
             }
        }
        return true;
    }
}
