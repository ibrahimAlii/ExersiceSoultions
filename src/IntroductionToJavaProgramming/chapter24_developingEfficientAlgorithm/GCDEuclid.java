package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm;

public class GCDEuclid {


    //
    /**
     *
     * The algorithm can proved that the worst-case time complexity is O(logn).
     */
    public static void main(String[] args){

        System.out.println(gcd(2525, 125));

    }

    /**
     *
     * @param m first number
     * @param n second number
     * @return the GCD in just one step!
     */
    public static int gcd(int m, int n){
        if (m % n == 0)
            return n;
        else return gcd(m, m % n);
    }
}
