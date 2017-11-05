package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

public class ShuffleRows_7_18 {

    public static void shuffle() {

        int[][] list = {{1, 2}, {3, 4}, {5, 6}, {7, 8}, {9, 10}};

        shuffle(list);

        for (int[] aList : list) {
            for (int anAList : aList) {
                System.out.print(anAList + " ");
            }
            System.out.println();
        }
    }

    private static void shuffle(int[][] list) {

        int[] ar = new int[2];

        for (int i = 0; i < list.length; i++) {

            int index = (int) (Math.random() * list.length);

            ar[0] = list[i][0];
            ar[1] = list[i][1];
            list[i][0] = list[index][0];
            list[i][1] = list[index][1];
            list[index][0] = ar[0];
            list[index][1] = ar[1];
        }

    }
}
