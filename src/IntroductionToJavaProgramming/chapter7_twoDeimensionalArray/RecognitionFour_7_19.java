package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;


public class RecognitionFour_7_19 {

    public static void isConsecutiveFour() {

        int[][] list = initArr();

        System.out.println(isConsecutiveFour(list));


        for (int[] arr:
             list) {
            for (int val :
                    arr) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    private static boolean isConsecutiveFour(int[][] list) {

        for (int row = 0; row < list.length; row++) {

            for (int column = 0; column < list[row].length; column++) {

                int currentValue = list[row][column];

                if (isConsecutiveFourRow(list, row, currentValue) ||
                        isConsecutiveFourColumn(list, column, currentValue) ||
                        isConsecutiveFourMajor(list, currentValue))
                    return true;
            }
        }
        return false;
    }

    private static boolean isConsecutiveFourMajor(int[][] list, int currentValue) {

        int countMajorDiagonal = 0, countMajorSubDiagonal = 0;

        for (int majorDiagonal = 0; majorDiagonal < list.length; majorDiagonal++) {
            if (list[majorDiagonal][majorDiagonal] == currentValue)
                countMajorDiagonal++;
            else countMajorDiagonal = 0;
        }

        for (int subDiagonal = 0; subDiagonal < list.length; subDiagonal++) {
            if (list[subDiagonal][(list.length - subDiagonal) - 1] == currentValue)
                countMajorSubDiagonal++;
            else countMajorSubDiagonal = 0;
        }

        return countMajorDiagonal == 4 || countMajorSubDiagonal == 4;
    }

    private static boolean isConsecutiveFourColumn(int[][] list, int currentColumn, int currentValue) {

        int count = 0;
        for (int row = 0; row < list.length; row++) {
            if (list[row][currentColumn] == currentValue)
                count++;
            else
                count = 0;
        }
        return count == 4;
    }

    private static boolean isConsecutiveFourRow(int[][] list, int currentRow, int currentValue) {

        int count = 0;
        for (int column = 0; column < list[currentRow].length; column++) {
            if (list[currentRow][column] == currentValue)
                count++;
            else
                count = 0;
        }
        return count == 4;
    }

    private static int[][] initArr() {

        int[][] arr = new int[6][7];
        for (int row = 0; row < 6; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                int value = (int) (Math.random() * 5);
                arr[row][column] = value;
            }
        }
        return arr;
    }
}
