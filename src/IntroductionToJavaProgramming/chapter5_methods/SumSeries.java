package IntroductionToJavaProgramming.chapter5_methods;

/*
Page 240 * 5.13

 */
public class SumSeries {
    public static void getSumSeries(int n){
        double mOfI = 0;
        System.out.println("i \t \t \t \t  m(i)" );
        for (int i = 1; i <= n; i++) {
            double sum = i + 1;
            mOfI += i / sum;

            System.out.println(i + "\t \t \t \t   " + (float) mOfI);
        }
    }
}
