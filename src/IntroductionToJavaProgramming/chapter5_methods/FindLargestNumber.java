package IntroductionToJavaProgramming.chapter5_methods;

public class FindLargestNumber {
    public static void displayLargestNumber(double num1,
                                            double num2,
                                            double num3)
    {
        double largestNum = 0;
        for (int i = 0; i <= 3 /*params count*/ ; i++) {
            largestNum = num1;
            if (num2 > largestNum){
                largestNum = num2;
            }
            if (num3 > largestNum){
                largestNum = num3;
            }
        }
        System.out.print(largestNum);

    }
}
