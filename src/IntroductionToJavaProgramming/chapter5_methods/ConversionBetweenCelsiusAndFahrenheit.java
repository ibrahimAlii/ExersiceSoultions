package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;
/*
Page 239  5.8

(Conversion between Celsius and Fahrenheit) Write a class that contain that contain the following two methods:
public static double celsiusToFahrenheit(double celsius)

public static double fahrenheitToCelsius(double fahrenheit)

.....
 */
public class ConversionBetweenCelsiusAndFahrenheit {
    public static double celsiusToFahrenheit(double celsius){
        return (9.0 / 5) * celsius + 32; // return fahrenheit
    }
    public static double fahrenheitToCelsius(double fahrenheit){
        return (5.0 / 9) * (fahrenheit - 32); // return celsius
    }

    public static void getCelsiusAndFahrenheit(){
        Scanner input = new Scanner(System.in);

        System.out.println("Input celsius");
        double celsius = input.nextDouble();
        System.out.println("Input fahrenheit");
        double fahrenheit = input.nextDouble();

        System.out.println("Celsius \t \t" + "Fahrenheit \t \t" + "|\t" + "Fahrenheit \t \t" + "Celsius");
        System.out.println("_____________________________________________________________________________");

        for (double i = (double) celsius, j = fahrenheit; i > 0 && j > 0; i--, j-=10) {
            System.out.println(i + " \t \t \t  " + (float)celsiusToFahrenheit(i) + "\t \t \t|" +
                    "\t" + j + "\t \t \t" + (float)fahrenheitToCelsius(j));
        }

    }
}
