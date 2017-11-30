package IntroductionToJavaProgramming.basics;

import java.util.Scanner;

public class SumOfPostiveAndNegativeNumbers {
    public void getSum(){
        Scanner input = new Scanner(System.in);
        int sumOfPositive = 0, sumOfNegative = 0, num = 1;

        while (num != 0){
            num = input.nextInt();
            if (num >  0){
                sumOfPositive += num;
            }else {
                sumOfNegative += num;
            }
        }
        System.out.println("positive numbers is " + sumOfPositive);
        System.out.println("negative numbers is " + sumOfNegative);
    }
}
