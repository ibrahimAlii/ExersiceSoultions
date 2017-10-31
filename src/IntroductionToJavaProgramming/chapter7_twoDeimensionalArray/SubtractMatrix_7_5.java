package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class SubtractMatrix_7_5 {

    public static void subtractMatrix(){

        Scanner input = new Scanner(System.in);
        System.out.print("Enter size of both matrix: ");
        int size = input.nextInt();
        double[][] list1 = new double[size][size];
        double[][] list2 = new double[size][size];
        System.out.println("Enter matrix 1: ");

        getArrInput(list1);
        System.out.println("Enter matrix 2: ");
        getArrInput(list2);

        double[][] arr = subtractMatrix(list1, list2, size);
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }

    }

    private static double[][] subtractMatrix(double[][] list1, double[][] list2, int size){

        double[][] subtractedArr = new double[size][size];
        for (int row = 0; row < list1.length; row++) {
            for (int column = 0; column < list1[row].length; column++) {
                subtractedArr[row][column] = list1[row][column] - list2[row][column];
            }
        }

        return subtractedArr;
    }
    private static void getArrInput(double[][] arr){

        Scanner input = new Scanner(System.in);

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = input.nextDouble();
            }
        }
    }
}
