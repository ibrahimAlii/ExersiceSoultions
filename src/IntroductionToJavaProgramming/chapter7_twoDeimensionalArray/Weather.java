package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class Weather {

    public static void getWeather() {

        final int NUMBER_OF_DAYS = 10;
        final int NUMBER_OF_HOURS = 24;
        double[][][] data = new double[NUMBER_OF_DAYS][NUMBER_OF_HOURS][2];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < NUMBER_OF_DAYS * NUMBER_OF_HOURS; i++) {
            int day = scanner.nextInt();
            int hour = scanner.nextInt();
            double temperature = scanner.nextDouble();
            double humidity = scanner.nextDouble();

            data[day - 1][hour - 1][0] = temperature;
            data[day - 1][hour - 1][1] = humidity;
        }

        //find average
        for (int i = 0; i < NUMBER_OF_DAYS; i++) {
            double dailyTemperatureTotal = 0, dailyHumidityTotal = 0;
            for (int j = 0; j < NUMBER_OF_HOURS; j++) {
                dailyTemperatureTotal += data[i][j][0];
                dailyHumidityTotal += data[i][j][0];
            }

            System.out.println((dailyTemperatureTotal / NUMBER_OF_DAYS) + " " + (dailyHumidityTotal / NUMBER_OF_HOURS));
        }


    }
}
