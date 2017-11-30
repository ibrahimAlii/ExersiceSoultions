package IntroductionToJavaProgramming.basics;

import java.util.Scanner;

public class SumDigitsOfNumbers {

    public void getSum(){
        Scanner input = new Scanner(System.in);
        int num, digit, sum = 0, newSum = 0;

        num = input.nextInt();
        while (num > 0){
            digit = num % 10;
            num = num / 10;
            sum += digit;
        }

        System.out.println(sum);
        if (sum > 9){
            while (sum > 0) {
                digit = sum % 10;
                sum = sum / 10;
                newSum += digit;
            }
        }

        System.out.println(newSum);
    }
}
