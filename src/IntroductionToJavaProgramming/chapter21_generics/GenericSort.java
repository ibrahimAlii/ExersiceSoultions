package chapter21;

public class GenericSort {

    public static void main(String[] arg) {

        Integer[] intArr = {1, 8, 9, 2};

        Double[] doubles = {2.2, 9.8, 1.6, 5.5};

        Character[] characters = {'a', 'w', 'b', 'c'};

        String[] strings = {"Ibrahim", "Mohammed", "Saad", "Ahmed"};

        sort(intArr);
        sort(doubles);
        sort(characters);
        sort(strings);

        printList(intArr);
        printList(doubles);
        printList(characters);
        printList(strings);
    }

    public static <E extends Comparable<E>> void sort(E[] list) {

        E currentMin;
        int currentMinIndex;

        for (int i = 0; i < list.length - 1; i++) {

            currentMin = list[i];
            currentMinIndex = i;

            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
        }
    }

    public static void printList(Object[] list) {
        for (Object aList : list) System.out.print(aList + " ");

        System.out.println();
    }
}
