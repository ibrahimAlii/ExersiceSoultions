package IntroductionToJavaProgramming.chapter5_methods;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;

public class ApproximateTheSquareRoot {


    public static double getApproximatedSquare(long n) {
        DecimalFormat decimalFormat = new DecimalFormat("#.####");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);

        double lastGuess, nextGuess = 1;
        double init = 0.0001;
        do {
            lastGuess = nextGuess;
            nextGuess = (lastGuess + (double) n / lastGuess) / 2;
            System.out.println(decimalFormat.format(lastGuess)+" ---> "+decimalFormat.format(nextGuess));
        } while (Math.abs(lastGuess - nextGuess) >= init);

        return lastGuess;
    }

}
