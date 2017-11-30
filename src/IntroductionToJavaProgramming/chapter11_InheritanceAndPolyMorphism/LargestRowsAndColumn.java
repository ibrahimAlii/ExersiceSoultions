package IntroductionToJavaProgramming.chapter11_InheritanceAndPolyMorphism;

import java.util.ArrayList;
import java.util.Scanner;

public class LargestRowsAndColumn {

    public static void getLargestArray() {


        Scanner input = new Scanner(System.in);
        System.out.print("Enter the array size n: ");
        int size = input.nextInt();

        ArrayList<Integer> list = initArrayList(size);

        printLargestColumnAndRow(size, list);
    }

    // FIXME: 26/11/2017 make me two dimensional array[][]
    private static void printLargestColumnAndRow(int size, ArrayList list) {

        System.out.println("The random array is: ");
        ArrayList largestColumns = new ArrayList();
        ArrayList largestRows = new ArrayList();
        int rowsIndex =0, columnsIndex = 0;
        largestColumns.add((Integer) list.get(columnsIndex));
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i));
            if ((i + 1) % size == 0) {
                System.out.println();
                rowsIndex++;
                columnsIndex++;

            }
            largestColumns.add((Integer) list.get(columnsIndex + size));

        }
        System.out.println(largestColumns);
    }

    private static ArrayList<Integer> initArrayList(int size) {

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < size * size; i++) {
            list.add(i, (int) (Math.random() * 2));
        }
        return list;
    }
}
