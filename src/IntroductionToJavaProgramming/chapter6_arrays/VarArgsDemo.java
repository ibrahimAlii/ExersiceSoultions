package IntroductionToJavaProgramming.chapter6_arrays;

public class VarArgsDemo {
    public static void printMax(double... numbers) {
        if (numbers.length == 0) {
            System.out.println("No argument Passed");
            return;
        }

        double result = numbers[0];
        for (int i = 0; i < numbers.length; i++)
            if (numbers[i] > result)
                result = numbers[i];


        System.out.println("The max value is: " + result);

    }
}
