package IntroductionToJavaProgramming.basics;

/**
 * Created by Ibrahim on 11/08/2017.
 */
public class Fibonacci {

    public void fibo(int n) {

        //Fn = Fn-1 + Fn-2;
        int Fn1 = 0, Fn2 = 1, Fn3;
        System.out.print(" " + Fn1 + " " + Fn2);
        for (int i = 2; i < n; i++) {
            Fn3 = Fn1 + Fn2;
            System.out.print(" " + Fn3);
            Fn1 = Fn2;
            Fn2 = Fn3;
        }
    }
}
