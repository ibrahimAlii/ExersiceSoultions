package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

/*
 a class to check if sold all tickets or not
 */
public class CheckAllTickets {

    public static void checkAll(){
        Scanner scanner = new Scanner(System.in);
        boolean[] isCovered = new boolean[10];

        //read each number and check it by depend on boolean
        int ticketNum = scanner.nextInt();
        while (ticketNum != 0){
            isCovered[ticketNum - 1] = true;
            ticketNum = scanner.nextInt();
        }

        boolean allCovered = true;
        String unSold = "";
        int tickerRemain= 0;
        for (int i = 0; i < isCovered.length; i++) {
            if (!isCovered[i]) {
                allCovered = false;
                tickerRemain++;
                unSold += " " +  (i + 1);

            }
        }

        if (allCovered)
            System.out.println("All sold");
        else
            System.out.println("There is some more " + tickerRemain + "and the unsold tickets is" + unSold);
    }

}
