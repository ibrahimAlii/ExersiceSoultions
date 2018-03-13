package chapter20;

import java.math.BigInteger;

public class BigIntegerFactorial {

    private static BigInteger value = BigInteger.ONE;
    public static void main(String[] arg){
        System.out.println(factorial(100, value));

    }

    public static BigInteger factorial(int n, BigInteger value){
        if (n == 0)
            return value;
        else return factorial(n - 1, value.multiply(BigInteger.valueOf(n)));
    }
}
