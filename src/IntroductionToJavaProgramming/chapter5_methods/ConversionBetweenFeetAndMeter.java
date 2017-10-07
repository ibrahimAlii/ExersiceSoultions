package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

public class ConversionBetweenFeetAndMeter {
    public static double footToMeter(double foot){
        return 0.305 * foot;
    }
    public static double meterToFoot(double meter){
        return 3.279 * meter;
    }

    public static void getFeetAndMeters(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input Feet");
        double feet = input.nextDouble();
        System.out.println("Input Meter");
        double meter = input.nextDouble();

        System.out.println("Feet \t \t" + "Meters \t \t" + "|\t" + "Meters \t \t" + "Feet");
        System.out.println("_____________________________________________________________________________");

        for (double i = 1, j = meter; i <= feet && j > 0; i++, j+=5) {
            System.out.println(i + " \t \t " + (float)footToMeter(i) + "\t \t|" +
                    "\t" + j + "\t \t" + (float)meterToFoot(j));
        }

    }
}
