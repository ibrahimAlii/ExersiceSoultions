package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class Game_ConnectFour_7_20 {

    public static void startGame() {

        String[][] board = initArray();

        printBoard(board);

        displayGame(board);
    }

    private static void printBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[row].length; column++) {
                System.out.print("|" + board[row][column]);
            }
            System.out.println("|");
        }
    }

    private static void displayGame(String[][] board) {
        Scanner input = new Scanner(System.in);
        String currentPlayer = "R", playerName = "Red";
        for (int row = board.length - 1; row > 0; row--) {
            int currentRow = row;
            for (int column = 0; column < board[row].length; column++) {
                currentRow = board.length - 1;
                currentPlayer = (currentPlayer.equals("R") ? "Y" : "R");
                playerName = (playerName.equals("Red") ? "Yellow" : "Red");
                System.out.println("Drop a " + playerName + " disk at column (0-6)");
                int gameStep = input.nextInt();

                while (!board[currentRow][gameStep].equals(" ")) {
                    currentRow--;
                }
                board[currentRow][gameStep] = currentPlayer;
                printBoard(board);
                if (isConsecutiveFour(board, currentPlayer, currentRow, gameStep))
                    System.out.println("Winner");
            }
        }
    }

    private static boolean isConsecutiveFour(String[][] list, String currentPlayer, int row, int column) {
        return isConsecutiveFourRow(list, row, currentPlayer) ||
                isConsecutiveFourColumn(list, column, currentPlayer) ||
                isConsecutiveFourMajor(list, currentPlayer, row, column);
    }

    private static boolean isConsecutiveFourMajor(String[][] list, String currentValue, int currentRow, int currentColumn) {

        int countMajorDiagonal = 0, countMajorSubDiagonal = 0;


        for (int majorDiagonal = currentRow + 1, column = currentColumn; majorDiagonal < list.length; majorDiagonal++, column++) {
            if (countMajorDiagonal == 4)
                break;
            if (list[majorDiagonal][column].equals(currentValue))
                countMajorDiagonal++;
            else countMajorDiagonal = 0;
            System.out.print(countMajorDiagonal + " ");
        }

//        for (int majorDiagonal = 0; majorDiagonal < list.length; majorDiagonal++) {
//            for (int j = majorDiagonal; j < majorDiagonal + 1; j++) {
//
//                if (countMajorDiagonal == 4)
//                    break;
//                if (list[majorDiagonal][j].equals(currentValue))
//                    countMajorDiagonal++;
//                else countMajorDiagonal = 0;
//                System.out.print(countMajorDiagonal + " ");
//            }
//        }

        System.out.println();
        for (int subDiagonal = 0; subDiagonal < list.length; subDiagonal++) {
            if (countMajorSubDiagonal == 4)
                break;
            if (list[subDiagonal][(list.length - subDiagonal) - 1].equals(currentValue))
                countMajorSubDiagonal++;
            else countMajorSubDiagonal = 0;
        }

        return countMajorDiagonal == 4 || countMajorSubDiagonal == 4;
    }

    private static boolean isConsecutiveFourColumn(String[][] list, int currentColumn, String currentValue) {

        int count = 0;
        for (int row = 0; row < list.length; row++) {
            if (list[row][currentColumn].equals(currentValue))
                count++;
            else
                count = 0;
        }
        return count == 4;
    }

    private static boolean isConsecutiveFourRow(String[][] list, int currentRow, String currentValue) {

        int count = 0;
        for (int column = 0; column < list[currentRow].length; column++) {
            if (count == 4)
                break;
            if (list[currentRow][column].equals(currentValue))
                count++;
            else
                count = 0;
        }
        return count == 4;
    }


    private static String[][] initArray() {

        String[][] arr = new String[6][7];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = " ";
            }
        }
        return arr;
    }
}
