package IntroductionToJavaProgramming.chapter20_recursion;

public class RecursiveSelectionSort {

    public static void main(String[] ml) {

        sort(new double[]{1, 5, 1, 5, 5, 58, 5, 4, 84, 52, 1, 584, 5, 2, 1, 8});
    }

    public static void sort(double[] list) {
        sort(list, 0, list.length - 1);
    }

    public static void sort(double[] list, int low, int height) {

        if (low < height) {

            int indexOfMin = low;
            double min = list[low];
            for (int i = low + 1; i <= height; i++) {
                if (list[i] < min) {
                    min = list[i];
                    indexOfMin = i;
                }
            }

            list[indexOfMin] = list[low];
            list[low] = min;

            sort(list, low + 1, height);
        }
    }
}
