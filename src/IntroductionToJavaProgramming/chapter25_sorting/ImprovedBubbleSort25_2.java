package IntroductionToJavaProgramming.chapter25_sorting;

public class ImprovedBubbleSort25_2 {


    public static void main(String[] args) {

        int[] list = {1, 5, 9, 8, -1, 44, 20, 101, 7, 16, 5};

        bubbleSort(list);

        for (int i = 0; i < list.length; i++)
            System.out.printf("%d%s" , list[i], " ");

    }

    private static void bubbleSort(int[] list) {
        boolean needNextPass = true;

        for (int k = 1; k < list.length && needNextPass; k++) {

            needNextPass = false;

            for (int i = 0; i < list.length - k; i++) {
                if (list[i] < list[i + 1]) {

                    int temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    needNextPass = true;
                }
            }
        }
    }
}
