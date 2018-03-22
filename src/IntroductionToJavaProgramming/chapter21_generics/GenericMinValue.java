package chapter21;

public class GenericMinValue {

    public static void main(String[] args){

        Integer[] arr = new Integer[]{5, 2, 1, 6, 4, 2, 9, 0};
        System.out.println(min(arr));
    }

    public static <E extends Comparable<E>> E min(E[] list){
        E min = list[0];

        for (E aList : list) {
            if (min.compareTo(aList) > 0)
                min = aList;
        }
        return min;
    }
}
