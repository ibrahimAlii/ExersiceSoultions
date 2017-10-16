package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

/*
Craps Game
 */
public class Craps {

    public static void startGame() {
        Scanner scanner = new Scanner(System.in);
        int winningGame = 0;
        //for (int i = 0; i < 5000; i++) {
            int firstDice = scanner.nextInt();
            int secondDice = scanner.nextInt();


            if (craps(firstDice, secondDice))
                System.out.println("You Lose");

            if (win(firstDice, secondDice)) {
                System.out.println("You Win");
                winningGame++;
            }


            if (normal(firstDice, secondDice)) {
                System.out.println("Point is " + (firstDice + secondDice));
                firstDice = scanner.nextInt();
                secondDice = scanner.nextInt();
                if (natural(firstDice, secondDice)) {
                    System.out.println("You Win");
                    winningGame++;
                } else {
                    System.out.println("You Lose");
                }
            }
       // }
        System.out.println("Winning games: " + winningGame);
    }

    private static boolean normal(int firstDice, int secondDice) {
        int sum = firstDice + secondDice;
        return sum == 4 || sum == 5 || sum == 6 || sum == 8 || sum == 9 || sum == 10;
    }

    private static boolean natural(int firstDice, int secondDice) {
        int sum = firstDice + secondDice;
        return sum != 7;
    }

    private static boolean win(int firstDice, int secondDice) {
        int sum = firstDice + secondDice;
        return sum == 7 || sum == 11;
    }

    private static boolean craps(int firstDice, int secondDice) {
        int sum = firstDice + secondDice;
        return sum == 2 || sum == 3 || sum == 12;
    }

}
