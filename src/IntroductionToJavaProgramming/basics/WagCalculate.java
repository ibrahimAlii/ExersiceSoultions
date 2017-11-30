package IntroductionToJavaProgramming.basics;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by Ibrahim on 10/08/2017.
 */
public class WagCalculate {

    public void calculate(int days){
        float firstDay = 1f;
        float sum = 0f;
        for (int i = 0; i < days; i++) {
            sum += firstDay;
        }
        System.out.print(sum / 100);





//        Scanner input = new Scanner(System.in);
//
//        DecimalFormat formatter = new DecimalFormat("#.00");
//        int numberOfDaysWorked;
//        double totalPay, salary, pennies;
//
//        System.out.println("Enter number of days:");
//        numberOfDaysWorked = input.nextInt();
//
//        while(numberOfDaysWorked < 1)
//        {
//            System.out.println("Must enter number greater than 1:");
//            System.out.println("Enter number of days:");
//            numberOfDaysWorked = input.nextInt();
//        }
//
//        System.out.println("Day        Amount(Dollars)");
//        System.out.println("--------------------------");
//
//        int day = 0;
//        pennies = 1;
//        totalPay = 0;
//
//        for(int x = 1; x <= numberOfDaysWorked; x++)
//        {
//            day++;
//            if(day > 1)
//            {
//                pennies *= 2;
//                salary = pennies/100;
//                System.out.println(day + "          $ " + formatter.format(salary));
//            }
//            else
//            {
//                salary = pennies/100;
//                System.out.println(day + "          $ " + formatter.format(salary));
//            }
//
//            totalPay += salary;
//        }
//
//        System.out.println("The total pay is: " + totalPay);

    }
}
