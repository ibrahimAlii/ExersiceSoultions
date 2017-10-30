package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class CheckSudokuSolution {

    public static void checkSudukoSolution() {

        int[][] grid = readSolutions();

        System.out.println((isValid(grid) ? "It's valid solution!" : "It's not valid."));
    }

    private static boolean isValid(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j] < 1 || grid[i][j] > 9
                        || !isValid(i, j, grid))
                    return false;
            }
        }
        return true;
    }

    private static boolean isValid(int i, int j, int[][] grid) {

        for (int column = 0; column < grid.length; column++)
            if (column != j && grid[i][column] == grid[i][j])
                return false;

        for (int row = 0; row < grid.length; row++)
            if (row != i && grid[row][j] == grid[i][j])
                return false;

        for (int row = (i / 3) * 3; row < (i / 3) * 3 + 3; row++)
            for (int column = (j / 3) * 3; column < (j / 3) * 3 + 3; column++)
                if (row != i && column != j && grid[row][column] == grid[i][j])
                    return false;

        return true;
    }

    private static int[][] readSolutions() {
        Scanner input = new Scanner(System.in);
        int[][] grid = new int[9][9];
        System.out.println("Enter full solution");
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid.length; j++)
                grid[i][j] = input.nextInt();

        return grid;
    }
}
