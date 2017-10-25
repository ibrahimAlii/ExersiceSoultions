package IntroductionToJavaProgramming.chapter6_arrays;

public class CheckSorted {

    public static boolean isSorted(int[] list){
        for (int i = 0; i < list.length - 1; ++i) {
            if (list[i + 1] < list[i]) return false;
        }
        return true;
    }

}
