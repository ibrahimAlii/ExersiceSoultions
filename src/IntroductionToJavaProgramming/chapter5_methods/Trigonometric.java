package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

public class Trigonometric {

    public static void getTrigonometric(){
        int DEGREES = 360;
        System.out.println("Degree          Tan\n" +
                "____________________");
        for (double i = 0; i < DEGREES; i+=10) {
            System.out.println(i + "          " + getTan(i));
        }
    }

    private static double getTan(double i) {
        i = Math.round(Math.tan((float)i));
        return i;
    }
}
