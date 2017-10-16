package IntroductionToJavaProgramming.chapter5_methods;

public class TwinePrime {

    /*
    Twin prime is a prime the differ from first one by 2, e.g 5,7 11 ,13
     */
    private static int REQUIRED_TWIN_NUMBER;
    private static int firstPrime, lastPrime;
    public static void getTwinPrime(){
        REQUIRED_TWIN_NUMBER = 1000;


        for (int i = 0; i < REQUIRED_TWIN_NUMBER; i++) {
            if (PrimeNumbers.isPrime(i) &&
                    PrimeNumbers.isPrime(i + 2)){

               System.out.println("(" + i +", " + (i + 2) + ")");
            }
        }

    }


}
