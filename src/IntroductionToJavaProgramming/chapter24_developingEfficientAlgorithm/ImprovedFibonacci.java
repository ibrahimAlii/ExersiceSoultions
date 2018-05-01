package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm;

public class ImprovedFibonacci {

    public static void main(String[] args) {


        System.out.println(fib(5));
    }

    public static long fib(long index) {
        long f0 = 0; // For fib(0)
        long f1 = 1; // For fib(1)
        long f2 = 1; // For fib(2)

        if (index == 0)
            return f0;
        else if (index == 1)
            return f1;
        else if (index == 2)
            return f2;

        for (int i = 3; i <= index; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f0 + f1;
        }

        return f2;
    }
}
