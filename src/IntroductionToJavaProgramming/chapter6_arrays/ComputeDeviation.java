package IntroductionToJavaProgramming.chapter6_arrays;

public class ComputeDeviation {

    public static double deviation(double[] numbers){

        double deviation = 0;

        for (double num :
                numbers) {

            deviation += Math.pow(num - mean(numbers), 2);
        }

        return Math.sqrt(deviation /= numbers.length);

    }

    public static double mean(double[] numbers){

        double sum = 0;

        for (int i = 0; i < numbers.length; i++) {
            sum += numbers[i];
        }

        return sum /= numbers.length;
    }
}
