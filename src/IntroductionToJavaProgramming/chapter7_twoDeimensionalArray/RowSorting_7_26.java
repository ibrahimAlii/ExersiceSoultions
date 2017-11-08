package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Arrays;

public class RowSorting_7_26 {

    public static void sortRows() {

        double[][] debugArr = initArray();

        double[][] arr = sortRows(debugArr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static double[][] initArray() {
        return new double[][]{{0.15, 0.875, 0.375},
                {0.55, 0.005, 0.225},
                {0.30, 0.12, 0.4}};
    }

    private static double[][] sortRows(double[][] debugArr) {

        double[][] arr = initArray();
//
//        for (int row = 0; row < arr.length; row++) {
//            int index = row;
//            double minVal = arr[row][0];
//            for (int column = 0; column < arr[row].length; column++) {
//
//                if (arr[row][column] < minVal) {
//                    minVal = arr[row][column];
//                    index = column;
//                }
//
//
//            }
//
//            if (index != row){
//                arr[row][index] = arr[row][0];
//                arr[row][0] = minVal;
//            }
//
//
//        }

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr.length - 1; column++) {
                double min = arr[row][column];
                int index = column;
                for (int j = column + 1; j < arr.length; j++) {
                    if (min > arr[row][j]) {
                        min = arr[row][j];
                        index = j;
                    }
                }
                if (index != column) {
                    arr[row][index] = arr[row][column];
                    arr[row][column] = min;
                }
            }
        }
//        for (double[] innerArray: arr) {
//            Arrays.sort(innerArray);
//        }
        return arr;
    }

}
