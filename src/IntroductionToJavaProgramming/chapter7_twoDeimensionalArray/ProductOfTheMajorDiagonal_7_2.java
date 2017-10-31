package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class ProductOfTheMajorDiagonal_7_2 {

    public static void productMajorDiagonal(){

        System.out.println("Enter array width and high");
        Scanner input = new Scanner(System.in);
        int size = input.nextInt();
        double[][] list = new double[size][size];
        System.out.println("Enter list elements");

        for (int i = 0; i < list.length; i++)
            for (int j = 0; j < list[i].length; j++)
                list[i][j] = input.nextDouble();


        System.out.println(productMajorDiagonal(list, size));
    }

    private static double productMajorDiagonal(double[][] list, int size) {

        double sum = 1;

        for (int column = 0; column < list[0].length; column++) {
            for (int row = 0; row < list.length; row++) {
                sum *= list[row][column];
            }
        }
        return sum;
    }
}
