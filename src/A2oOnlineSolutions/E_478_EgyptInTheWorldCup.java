package A2oOnlineSolutions;

import java.util.Scanner;

public class E_478_EgyptInTheWorldCup {
    public static void getHighScoresOfTeam() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("how many cases");
        int cases = scanner.nextInt();
        String [] winnerTeams = new String[cases];
        for (int i = 0; i < cases; i++) {
            winnerTeams[i] = getWinnersTeam();

        }

        for (int i = 0; i < cases; i++) {
            System.out.println(winnerTeams[i] + "\n");
        }


    }

    public static String getWinnersTeam() {
        Scanner sc = new Scanner(System.in);
        int bestScore = Integer.MIN_VALUE;
        String team = "Nothing entered";
        System.out.println("how many teams");
        int count = sc.nextInt();
        sc.nextLine();
        while (count-- > 0) {

            System.out.println("Entered team,score");

            String line = sc.nextLine();
            String arr [] = line.split(" ");
            // check size - TBD
            if (Integer.parseInt(arr[1]) > bestScore) {
                bestScore = Integer.parseInt(arr[1]);
                team = arr[0];
            }
        }

        System.out.println("nest team is " + team + " with a score of " + bestScore);
        return team;
    }
}
