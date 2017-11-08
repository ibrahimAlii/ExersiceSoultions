package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

public class ColumnSorting_7_27 {

    public static void sortColumns(){

        double[][] arr = initArray();

        sortColumns(arr);

        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                System.out.print(arr[row][column] + " ");
            }
            System.out.println();
        }

    }

    private static void sortColumns(double[][] arr) {

        for (int column = 0; column < arr.length; column++) {

            for (int row = 0; row < arr.length - 1; row++) {
                double min = arr[row][column];
                int index = row;
                for (int j = row + 1; j < arr.length; j++) {
                    if (min > arr[j][column]) {
                        min = arr[j][column];
                        index = j;
                    }
                }
                if (index != row) {
                    arr[index][column] = arr[row][column];
                    arr[row][column] = min;
                }
            }
        }

    }

    public static double[][] initArray() {
        return new double[][]{{0.15, 0.875, 0.375},
                {0.55, 0.005, 0.225},
                {0.30, 0.12, 0.4}};
    }
}
