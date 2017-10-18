package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

public class ZellerCongruence {

    public static String getDayOfMonth() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input the year e.g 2017");
        int year = scanner.nextInt();

        System.out.println("Input the month e.g 3");
        int month = scanner.nextInt();


        System.out.println("Input the day of month e.g 1-31");
        int day = scanner.nextInt();

        String days[] = { "Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday" };
        int cenYr = year % 100;
        int cen = year / 100;

        if (month <= 2) {
            year -= 1;
            month += 12;
        }

        /****************************************
         * ALGORITHM:
         *   weekDay = (day + [13(month + 1)/5] + year of century + [year of century/4] + [century/4] - [2*century]) MOD 7
         * ************************************/

        int weekDay = (day + ( ( 13*(month+1) )/5 ) + cenYr + (cenYr/4) + (cen/4) - (2*cen) );
        weekDay %= 7;

        return days[weekDay];
    }
}
