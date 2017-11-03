package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class LocateSmallestElement_7_13 {

    public static void getSmallestElement() {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int rowSize = input.nextInt();
        System.out.print("\n Enter column size");
        int columnSize = input.nextInt();
        System.out.println("Enter the array: ");
        double[][] arr = initArr(rowSize, columnSize);
        int[] smallestElement = getSmallestElement(arr);

        System.out.print("The location of the smallest element is at: (" + smallestElement[0] + ", " + smallestElement[1]+ " )");

    }


    private static int[] getSmallestElement(double[][] arr) {

        int[] smallestElements = new int[2];

        for (int row = 0; row < arr.length; row++) {

            for (int column = 0; column < arr[row].length; column++) {
                if (arr[row][column] < arr[smallestElements[0]][smallestElements[1]]) {
                    smallestElements[0] = row;
                    smallestElements[1] = column;
                }
            }
        }
        return smallestElements;
    }

    private static double[][] initArr(int rowSize, int columnSize) {

        Scanner input = new Scanner(System.in);
        double[][] arr = new double[rowSize][columnSize];

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = input.nextDouble();
            }
        }
        return arr;
    }


}
