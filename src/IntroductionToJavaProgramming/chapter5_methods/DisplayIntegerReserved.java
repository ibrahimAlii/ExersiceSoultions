package IntroductionToJavaProgramming.chapter5_methods;

/*
Page 238 *5.5
 */
public class DisplayIntegerReserved {

    public static int getReverse(int number){
        int digit, reverse = 0;
        for (int i = 0; i <= number; i++) {
            digit = number % 10;
            reverse = (reverse * 10) + digit;
            number = number / 10;
        }
        return reverse;
    }
}
