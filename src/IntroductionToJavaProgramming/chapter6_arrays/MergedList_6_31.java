package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class MergedList_6_31 {

    public static void mergeList() {

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter size of first list: ");
        int firstListSize = scanner.nextInt();
        int[] list1 = new int[firstListSize];

        for (int i = 0; i < list1.length; i++)
            list1[i] = scanner.nextInt();

        System.out.print("\nEnter second list size: ");
        int secondListSize = scanner.nextInt();
        int[] list2 = new int[secondListSize];
        for (int i = 0; i < list2.length; i++)
            list2[i] = scanner.nextInt();

        int[] arr = merge(list1, list2);



        for (int anArr : arr) System.out.print(" " + anArr);


    }


    public static int[] merge(int[] list1, int[] list2) {
        int[] mergedArr = new int[list1.length + list2.length];


        for (int i = 0; i < list1.length; i++)
            mergedArr[i] = list1[i];

        for (int i = 0, j = list1.length; i < list2.length; i++, j++)
            mergedArr[j] = list2[i];

        sort(mergedArr);

        return mergedArr;
    }

    private static void sort(int[] list){

        int minVal;
        int minValIndex ;
        for (int i = 0; i < list.length - 1; i++) {

            minVal = list[i];
            minValIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (minVal > list[j]){
                    minVal = list[j];
                    minValIndex = j;
                }
            }

            if (minValIndex != i){
                list[minValIndex] = list[i];
                list[i] = minVal;
            }

        }
    }
}
