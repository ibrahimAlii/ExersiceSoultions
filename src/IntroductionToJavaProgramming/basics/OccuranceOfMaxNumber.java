package IntroductionToJavaProgramming.basics;

import java.util.Scanner;

public class OccuranceOfMaxNumber {

    public void getOccurrenceOfMaxNumber(){
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        int max = 0, count = 0, value;

        while (num > 0){

            value = num % 10;
            num = num / 10;
            if (value > max){
                max = value;
                count = 1;
            }else if (value == max){
                count ++;
            }


        }

        System.out.println(max);
        System.out.println("count is " + count);
    }
}
