package IntroductionToJavaProgramming.chapter6_arrays;

public class AverageAnArray {

    public static int binarySearch(int[] list, int key) {

        int low = 0;
        int high = list.length - 1;
        while (high >= low) {
            int mid = (high + low) / 2;

            if (key < list[mid])
                high = mid - 1;
            else if (key == list[mid])
                return mid;
            else
                low = mid + 1;

        }

        return -1;

    }

    public static long binarySearch(long[] list, long key) {

        long low = 0;
        long high = list.length - 1;

        while (high >= low) {
            long mid = (low + high) / 2;

            if (key < list[(int) mid])
                high = mid - 1;
            else if (key == list[(int) mid])
                return mid;
            else
                low = mid + 1;
        }
        return -1;

    }
}
