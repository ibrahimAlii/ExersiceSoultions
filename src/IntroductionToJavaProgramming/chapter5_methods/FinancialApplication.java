package IntroductionToJavaProgramming.chapter5_methods;

public class FinancialApplication {
    public static double futureIncreaseValue(double amount,
                                             double increaseAmount,
                                             int year)
    {

        double increaseValue = (increaseAmount * amount / 100) ;
        System.out.println(increaseValue);
        double futureIncreasedAmount = amount * (1 + increaseValue);
        System.out.println("Year         "  + "Future Increase");
        for (int i = 0; i <= year; i++) {
            futureIncreasedAmount += futureIncreasedAmount *(increaseValue);
            System.out.println(i + "            " + futureIncreasedAmount);
        }
return 0;
    }
}
