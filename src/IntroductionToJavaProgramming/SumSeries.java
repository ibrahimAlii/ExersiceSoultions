package IntroductionToJavaProgramming;

/**
 * Created by Ibrahim on 10/08/2017.
 */
public class SumSeries {
    public void getSum(int input){
    //1 + (1 + 2) + (1 + 2 + 3) + ... + (1 + 2 + 3 + ... + n)
    String del;
    String delPlus = "";
    String rightPract = "", leftPract = "";
        for (int i = 2; i < input; i++) {
        System.out.print(delPlus + rightPract);
        del = "";
        for (int j = 1; j < i; j++) {
            System.out.print(del + j);
            del = " + ";
        }
        System.out.print(leftPract);
        delPlus = " + ";
        rightPract = "(";
        leftPract = ")";
    }
    }
}
