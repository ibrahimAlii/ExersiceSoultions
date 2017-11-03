package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

public class SortTwoDimensionalArray_7_16 {

    public static void sortArr(){

        int[][] list = {{4, 2}, {1, 7}, {4, 5}, {1, 2}, {1, 1}, {4, 1}};

        sortArr(list);

        for (int i = 0; i < list.length; i++) {
            for (int j = 0; j < list[i].length; j++) {
                System.out.print(list[i][j] + " ");
            }
        }
    }



    private static void sortArr(int[][] arr) {
        int[] arrin = new int[2];
        for (int row = 0; row < arr.length - 1; row++) {
            arrin[0] = arr[row][0];
            arrin[1] = arr[row][1];
            int index = row;
            for (int i = row + 1; i < arr.length; i++) {
                if (arr[i][0] <= arrin[0] && (arr[i][0] < arrin[1] ||
                        arr[i][1] < arrin[0] || arr[i][1] < arrin[1])) {
                    arrin[0] = arr[i][0];
                    arrin[1] = arr[i][1];
                    index = i;
                }
            }
            if (index != row) {
                arr[index][0] = arr[row][0];
                arr[index][1] = arr[row][1];
                arr[row][0] = arrin[0];
                arr[row][1] = arrin[1];
            }
        }

        /*or*/
//        for (int i = 0; i < arr.length; i++) {
//            for (int column = 0; column < arr.length - 1; column++) {
//                if(arr[column][0] > arr[column + 1][0]) {
//                    swap(arr, column);
//                } else if(arr[column][0] == arr[column + 1][0] && arr[column][1] > arr[column + 1][1]) {
//                    swap(arr, column);
//                }
//            }
//        }

    }

    private static void swap(int[][] arr, int column) {
        int[] temp = arr[column];
        arr[column] = arr[column + 1];
        arr[column + 1] = temp;
    }
}
