package IntroductionToJavaProgramming.basics;

import java.util.Scanner;

/**
 * Created by Ibrahim on 31/08/2017.
 */
public class PalindromeNumber {


    public void checkPalindrome(int n) {


        int r, sum = 0, temp;
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();//It is the number variable to be checked for palindrome

        temp = n;
        while (n > 0)

        {
            r = n % 10;  //getting remainder
            sum = (sum * 10) + r;
            n = n / 10;
        }

        if (temp == sum)
            System.out.println("palindrome number ");
        else
            System.out.println("not palindrome");
    }
}

