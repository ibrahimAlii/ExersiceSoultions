package IntroductionToJavaProgramming.chapter6_arrays;

public class BinaryVsLinearSearch {

    public static void runTest() {

        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000);
        }
        //selectionSort(arr);
        long startTime = System.currentTimeMillis();
        //task

        int v = linearSearch(arr, 9999);
        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;
        System.out.println(executionTime + " " + v);

    }

    private static int binarySearch(int[] list, int key) {

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

    public static int linearSearch(int[] list, int key) {

        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }

    public static void selectionSort(int[] list){

        for (int i = 0; i < list.length - 1; i++) {
            int currentMin = list[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin > list[j]){
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void insertionSort(int[] list){

        for (int i = 1; i < list.length; i++) {
            /*
             Insert list[i] into a sorted sublist list[0..i-1] so that list [0..i] is sorted.
             */
            int currentElement = list[i];
            int k;
            //shift
            for (k = i - 1; k >= 0 && list[k] > currentElement; k--) {
                list[k + 1] = list[k];
            }
            //Insert the current element into list[k+1]
            list[k + 1] = currentElement;
        }
    }
}
