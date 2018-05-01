package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm;

public class ImprovedGCD {

    public static void main(String[] arg) {

        System.out.println(gcd(2225, 125));
    }

    public static int gcd(int m, int n) {
        int gcd = 1;

        if (m % n == 0) return n;

        for (int k = n / 2; k >= 1; k--) { // Instead of incrementing we decrease it by decrementing to get the high GCD
            if (m % k == 0 && n % k == 0) {
                gcd = k;
                break;
            }
        }
        return gcd;
    }
}
