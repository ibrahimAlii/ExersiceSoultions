package IntroductionToJavaProgramming;

import java.util.Scanner;

/**
 * Created by Ibrahim on 03/09/2017.
 */
public class ArmstrongNumber {

    public void checkNumber(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = 0, value, temp = num;
        while (num > 0){
            value = num % 10;
            num = num / 10;
            sum += (value * value * value);
        }

        if (sum == temp){
            System.out.println("Success");
        }else {
            System.out.println("Failed");
           // checkNumber();
        }
    }
}
