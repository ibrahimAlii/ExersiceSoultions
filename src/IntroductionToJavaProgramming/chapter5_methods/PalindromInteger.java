package IntroductionToJavaProgramming.chapter5_methods;

/*
Page 238 **5.3
 */
public class PalindromInteger {

    public static int reverse(int number){
        if (isPalindrom(number))
            System.out.print("Palindrome");
        else
            System.out.print("Not Palindrome");

        return 0;
    }

    private static boolean isPalindrom(int number) {
        int digit, sum = 0, temp;
        temp = number;
        while (number > 0){
            digit = number % 10;
            sum = (sum * 10) + digit;
            number = number / 10;
        }
        System.out.print(sum);
        return sum == temp;
    }
}
