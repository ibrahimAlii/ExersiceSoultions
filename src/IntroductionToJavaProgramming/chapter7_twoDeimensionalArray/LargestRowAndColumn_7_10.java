package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class LargestRowAndColumn_7_10 {

    /*
    fill matrix with 0 and 1, then define which biggest row and column.
     */
    public static void findLargestRowAndColumn(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter matrix row and columns size: ");
        int size = input.nextInt();
        int[][] list = initiateArr(size);

        printLargest(list);
    }

    private static void printLargest(int[][] list) {
        int maxColumnIndex = 0;
        int maxRowIndex = 0;
        int sum = 1, newSum = 0;

        for (int row = 0; row < list[0].length; row++) {
            newSum = 0;
            for (int column = 0; column < list.length; column++) {
             newSum += list[row][column];
            }

            if (newSum > sum) {
                sum = newSum;
                maxRowIndex = row;
            }
        }

        int sumColumn = 0, newColumnSum = 0;
        for (int i = 0; i < list.length; i++) {
            newColumnSum = 0;
            for (int j = 0; j < list.length; j++) {
                newColumnSum += list[j][i];

            }
            if (newColumnSum > sumColumn){
                sumColumn = newColumnSum;
                maxColumnIndex = i;
            }
        }
        System.out.println( "Max Row index : " + maxRowIndex + "\n" + "Max column index : " + maxColumnIndex);

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
