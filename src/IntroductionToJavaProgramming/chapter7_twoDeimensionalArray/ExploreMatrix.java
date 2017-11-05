package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class ExploreMatrix {

    public static void exploreMatrix() {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter matrix row and columns size: ");
        int size = input.nextInt();
        int[][] list = initiateArr(size);

        printRow(list, size);
        printColumn(list, size);
        printDiagonal(list, size);
    }

    private static void printDiagonal(int[][] list, int size) {


        //major diagonal
        for (int i = 0; i < list.length; i++) {
            for (int j = i; j < i + 1; j++) {
                System.out.print(list[i][j] + " ");
            }
        }
        /*
        or
        for( int i = 0; i < matrixSize ; i ++){
            System.out.print( list[i][i] + " ");
        }

         */

        System.out.println();
        //major sub-diagonal
        for (int i = 0; i < list.length; i++) {
            System.out.print(list[i][(list.length - i) - 1] + " ");
        }
        /*
        or
        int length = (list.length / 2)  + 1;
        for (int i = 0; i < list.length; i++) {
            for (int j = (list.length / 2) + 1; j > length - i + 1; j--) {
                System.out.print(list[i][j] + " ");

            }
        }
         */

    }

    private static void printColumn(int[][] list, int size) {
        int zeroCount = 0, oneCount = 0;
        String column0Statue = "";
        String column1Statue = "";

        for (int row = 0; row < list.length; row++) {
            zeroCount = 0;
            oneCount = 0;
            for (int column = 0; column < list.length; column++) {
                if (list[column][row] == 0)
                    zeroCount++;

                if (list[column][row] == 1)
                    oneCount++;
            }
            if (zeroCount == size)
                column0Statue = "All 0s on column " + row;
            else
                column0Statue = "No full 0s on the same column";

            if (oneCount == size)
                column1Statue = "All 1s on column " + row;
            else
                column1Statue = "No full 1s on the same column";
        }

        System.out.println(column0Statue);
        System.out.println(column1Statue);
    }

    private static void printRow(int[][] list, int size) {


        int zeroSize = 0, oneSize = 0;
        String row0Statue = "";
        String row1Statue = "";

        for (int row = 0; row < list.length; row++) {
            zeroSize = 0;
            oneSize = 0;
            for (int column = 0; column < list[row].length; column++) {
                if (list[row][column] == 0)
                    zeroSize++;

                if (list[row][column] == 1)
                    oneSize++;
            }
            if (zeroSize == size)
                row0Statue = "All 0s on row " + row;
            else
                row0Statue = "No full 0s on the same row";

            if (oneSize == size)
                row1Statue = "All 1s on row " + row;
            else
                row1Statue = "No full 1s on the same row";
        }

        System.out.println(row0Statue);
        System.out.println(row1Statue);
    }

    private static int[][] initiateArr(int size) {

        int[][] arr = new int[size][size];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = (int) (Math.random() * 2);
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }
        return arr;
    }
}
