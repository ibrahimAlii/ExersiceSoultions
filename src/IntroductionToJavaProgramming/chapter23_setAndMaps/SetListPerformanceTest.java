package chapter23;

import java.util.*;

public class SetListPerformanceTest {

    static final int N = 50000;

    /**
     *
     * Result is :  1- HashSet
     *              2- LinkedHashSet
     *              3- TreeSet
     *              4- ArrayList
     *              5- LinkedList
     *
     *
     */
    public static void main(String[] gg) {

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(i);
        Collections.shuffle(list);

        Collection<Integer> set1 = new HashSet<>(list);
        System.out.println("Test time for hash the set is " + getSetTime(set1));
        System.out.println("Remove elements time for hash set is " + getRemoveTime(set1));

        Collection<Integer> set2 = new LinkedHashSet<>(list);
        System.out.println("Add members time for linked hash set is " + getSetTime(set2));
        System.out.println("Remove members time for linked hash set is " + getRemoveTime(set2));

        Collection<Integer> set3 = new TreeSet<>(list);
        System.out.println("Add members time for tree set is " + getSetTime(set3));
        System.out.println("Remove members time for tree set is " + getRemoveTime(set3));

        Collection<Integer> set4 = new ArrayList<>(list);
        System.out.println("Add members time for array list is " + getSetTime(set4));
        System.out.println("Remove members time for array list is " + getRemoveTime(set4));

        HashSet<String> strings = new LinkedHashSet<>();
        Collection<Integer> set5 = new LinkedList<>(list);
        System.out.println("Add members time for linked list is " + getSetTime(set5));
        System.out.println("Remove members time for linked list is " + getRemoveTime(set5));
    }

    public static long getSetTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.contains((int) (Math.random() * 2 * N));
        }
        return System.currentTimeMillis() - startTime;
    }

    public static long getRemoveTime(Collection<Integer> c) {
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < N; i++) {
            c.remove(i);
        }

        return System.currentTimeMillis() - startTime;
    }
}
