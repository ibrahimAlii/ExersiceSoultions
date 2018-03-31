package IntroductionToJavaProgramming.chapter21_generics;

public class GenericBubbleSort {

    public static void main(String[] args) {

        Integer[] arr = new Integer[]{1, 5, 8, 2, 3, 4};

        sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }


    public static <E extends Comparable<E>> void sort(E[] list) {
        int n = list.length;
        E currentMin;
        while (n != 1) {
            int newN = 1;
            for (int i = n - 1; i > 0; i--) {
                if (list[i - 1].compareTo(list[i]) > 0) {
                    currentMin = list[i - 1];
                    list[i - 1] = list[i];
                    list[i] = currentMin;

                    newN = i;
                }
            }
            n = newN;
        }

    }
}
