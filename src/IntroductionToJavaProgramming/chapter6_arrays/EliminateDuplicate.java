package IntroductionToJavaProgramming.chapter6_arrays;

public class EliminateDuplicate {

    public static int[] eliminateDuplicates(int[] list){

        int[] distinctList = new int[list.length];
        int counter = 0;
        for (int num :
                list) {
            if (linearSearch(distinctList, num) == -1){
                distinctList[counter] = num;
                counter++;
            }
        }
        return distinctList;
    }
    
    private static int linearSearch(int[] list, int key){

        for (int i = 0; i < list.length; i++) {
            if (key == list[i])
                return i;
        }
        return -1;
    }
}
