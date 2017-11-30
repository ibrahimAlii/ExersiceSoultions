package IntroductionToJavaProgramming.basics;

import java.util.Scanner;

/**
 * Created by Ibrahim on 31/08/2017.
 */
public class SumOfDigits {

    public void sum(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int sum = 0, dig;

        while (num > 0){
            dig = num % 10;

            sum +=  dig;
            num = num / 10;
        }

        System.out.println(sum);
    }
}
