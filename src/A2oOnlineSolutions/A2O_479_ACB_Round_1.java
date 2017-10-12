package A2oOnlineSolutions;

import java.util.Scanner;

public class A2O_479_ACB_Round_1 {

    /*
    The top M contestants will be qualified to the next round,
     plus anyone else who solved the same number of problems as the Mth contestant,
      but no one will be qualified if they don't solve anything correctly.
     */
    public static void getHighConstant() {
        int testCase, topContestantScore, plusAnyBody, firstContestant, secContestant;
        Scanner scanner = new Scanner(System.in);
        testCase = scanner.nextInt();
        for (int i = 0; i < testCase; i++) {
            firstContestant = scanner.nextInt();
            secContestant = scanner.nextInt();
            if (firstContestant > secContestant)
                topContestantScore = firstContestant;
            else
                topContestantScore = secContestant;

            System.out.println(topContestantScore);
        }
    }
}
