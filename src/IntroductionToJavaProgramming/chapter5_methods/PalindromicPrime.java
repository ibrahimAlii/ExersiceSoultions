package IntroductionToJavaProgramming.chapter5_methods;

public class PalindromicPrime {

    public static boolean isPalindromicPrime(int number){
        return PrimeNumbers.isPrime(number) && PalindromInteger.isPalindrom(number);
    }
}
