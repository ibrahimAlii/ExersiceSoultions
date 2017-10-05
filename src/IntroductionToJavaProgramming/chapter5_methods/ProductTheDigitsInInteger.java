package IntroductionToJavaProgramming.chapter5_methods;

/*
 Page 238 *5.2
 */
public class ProductTheDigitsInInteger {

    public static int productDigits(long number){
        long digit, result = 1; // result should be 1 at least
        while (number > 0){
            digit = number % 10; // get one digit from @number
            result = result * digit; // get result
            number = number / 10; // remove one digit from @number
        }

        return (int)result;
    }
}
