package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class SumOfOneColumn_7_1 {

    public static double sumOfColumn = 0;
    public static void getSum(){

        Scanner scanner = new Scanner(System.in);

        double[][] arr = new double[3][4];
        int columnIndex = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = scanner.nextDouble();
            }
        }

        for (int column = 0; column < arr[0].length; column++) {
            sumOfColumn = 0;
            for (int row = 0; row < arr.length; row++) {
                sumOfColumn += arr[row][column];
            }
            System.out.println("sum" + sumOfColumn);
        }
    }
}
