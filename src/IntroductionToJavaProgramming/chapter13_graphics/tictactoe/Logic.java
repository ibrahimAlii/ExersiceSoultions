package IntroductionToJavaProgramming.chapter13_graphics.tictactoe;

import java.util.Scanner;

public class Logic {



    public boolean thereIsDraw(String[][] x_o, String currentPlayer, int currentRow, int currentColumn) {

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
       if (isDraw) askForAnotherGame();
        return isDraw;
    }

    public boolean cellIsFree(String[][] x_o){
        for (int i = 0; i < x_o.length; i++) {
            for (int j = 0; j < x_o[i].length; j++) {
                if (x_o[i][j] != null || !x_o[i][j].equals(" ")) return false;
            }
        }
        return true;
    }

    public  boolean thereIsWinner(String[][] x_o, String currentPlayer, int currentRow, int currentColumn) {

        //check rows
        if (x_o[currentRow][0].equals(currentPlayer) &&  x_o[currentRow][1].equals(currentPlayer) && x_o[currentRow][2].equals(currentPlayer)
                || // check columns
                x_o[0][currentColumn].equals(currentPlayer) && x_o[1][currentColumn].equals(currentPlayer) && x_o[2][currentColumn].equals(currentPlayer)
                ||  // check diagonal
                currentRow == currentColumn && x_o[0][0].equals(currentPlayer) && x_o[1][1].equals(currentPlayer) && x_o[2][2].equals(currentPlayer)
                ||  // check opposite diagonal
                currentRow + currentColumn == 2 && x_o[1][1].equals(currentPlayer) && x_o[0][2].equals(currentPlayer) && x_o[2][0].equals(currentPlayer)) {
            System.out.println("We have a winner: " + currentPlayer);

            askForAnotherGame();
            return true;
        }
        return false;
    }

    public void askForAnotherGame() {
        Scanner sc = new Scanner(System.in);
        int gameStatue = sc.nextInt();
        if (gameStatue == 1) {
            new TicTacToe().startGame();
        }
        else {
            System.exit(1);
        }
    }
}
