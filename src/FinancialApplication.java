import java.util.Scanner;

/**
 * Created by Ibrahim on 31/08/2017.
 */
public class FinancialApplication {


    public void calculate(float amount, float interest, int months){

        System.out.println("Please Enter amount");
        Scanner scanner = new Scanner(System.in);

        amount = scanner.nextInt();

        System.out.println("Please Enter interest rate ");

        interest =  scanner.nextFloat();

        System.out.println("Please Enter months");

        months = scanner.nextInt();

        interest = interest / 100;
        interest = interest / 12;
        float oldAmount = amount * (1 + interest);

        float allAmount = 0;
        for (int i = 0; i < months ; i++) {

            allAmount = 0;
            allAmount = (amount + oldAmount) * (1 + interest);
            oldAmount = allAmount;

            System.out.println(allAmount);
        }



    }
}
