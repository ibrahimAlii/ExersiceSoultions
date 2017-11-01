package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class TicTacToe_7_9 {

    public static void startGame(){

        Scanner input = new Scanner(System.in);
        String[][] X_O = initiateArr();

        displayGame(input, X_O);




    }

    private static void displayGame(Scanner input, String[][] x_O) {
        String currentPlayer;
        int row = 0, column = 0;
        for (int i = 0; i < x_O.length; i++) {
            for (int j = 0; j < x_O[i].length; j++) {
                currentPlayer = (x_O[row][column].equals("X") ? "O" : "X");
                System.out.print("Enter a row (0, 1, or 2): " + currentPlayer + " ");
                row = input.nextInt();
                System.out.print("Enter a column (0, 1, or 2): " + currentPlayer + " ");
                column = input.nextInt();
                x_O[row][column] = currentPlayer;
                printForm(x_O);

                if (thereIsWinner(x_O, currentPlayer, i, j) || thereIsDraw(x_O, currentPlayer, i, j)) {
                    System.out.println("Would you like to continue ? input 1 for continue");
                    int gameCase = input.nextInt();
                    if (gameCase == 1)
                        startGame();
                    else
                        System.exit(0);
                    break;
                }
            }
        }
    }

    private static boolean thereIsDraw(String[][] x_o, String currentPlayer, int currentRow, int currentColumn) {

        boolean isDraw = false;
        for (int i = 0; i < x_o.length; i++) {
            for (int j = 0; j < x_o[i].length; j++) {
                if (!x_o[i][j].equals(" ") && !thereIsWinner(x_o, currentPlayer, currentRow, currentColumn)) {
                    isDraw = true;
                }else{
                    isDraw = false;
                    break;
                }
            }
        }
        System.out.print((isDraw ? "It's a draw!\n" : ""));
        return isDraw;
    }

    private static boolean thereIsWinner(String[][] x_o, String currentPlayer, int currentRow, int currentColumn) {

                    //check rows
            if (x_o[currentRow][0].equals(currentPlayer) &&  x_o[currentRow][1].equals(currentPlayer) && x_o[currentRow][2].equals(currentPlayer)
                    || // check columns
                    x_o[0][currentColumn].equals(currentPlayer) && x_o[1][currentColumn].equals(currentPlayer) && x_o[2][currentColumn].equals(currentPlayer)
                    ||  // check diagonal
                    currentRow == currentColumn && x_o[0][0].equals(currentPlayer) && x_o[1][1].equals(currentPlayer) && x_o[2][2].equals(currentPlayer)
                    ||  // check opposite diagonal
                    currentRow + currentColumn == 2 && x_o[1][1].equals(currentPlayer) && x_o[0][2].equals(currentPlayer) && x_o[2][0].equals(currentPlayer)) {
                System.out.println("We have a winner: " + currentPlayer);
                return true;
        }
        return false;
    }


    private static void printForm(String[][] x_o) {
        for (int i = 0; i < x_o.length; i++) {
            System.out.println("-------------");
            for (int j = 0; j < x_o[i].length; j++) {
                System.out.print("| " + x_o[i][j] + " ");
            }
            System.out.println("|");

        }

        System.out.println("-------------");
    }


    private static String[][] initiateArr() {

        String[][] arr = new String[3][3];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = " ";
            }
        }
        return arr;
    }
}
