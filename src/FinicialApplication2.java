import java.util.Scanner;

/**
 * Created by Ibrahim on 31/08/2017.
 */
public class FinicialApplication2 {

    public void calculate(float amount, float percentage, int months){

        System.out.println("Please Enter amount");
        Scanner scanner = new Scanner(System.in);

        amount = scanner.nextInt();

        System.out.println("Please Enter interest rate ");

        percentage =  scanner.nextFloat();

        System.out.println("Please Enter months");

        months = scanner.nextInt();


        float oldAmount = amount + amount * percentage / 1200;

        float allAmount = 0;
        System.out.println("Month    CD Value");
        for (int i = 1; i < months ; i++) {

            allAmount = 0;
            allAmount = oldAmount + oldAmount * percentage / 1200;
            oldAmount = allAmount;

            System.out.println(i + "   \t " + allAmount);
        }



    }
}
