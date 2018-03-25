package chapter22;

import java.util.Iterator;
import java.util.LinkedList;

public class IteratorVSget22_6 {

    /**
     *  Iterator is a lot efficient thant using list.get(index)
     *  Foreach is using the mechanism as Iterator (UnderWater)
     *
     * */
    public static void main(String[] gg){
        LinkedList<Integer> integerLinkedList = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            integerLinkedList.add((int) (Math.random() * 5000000));
        }

        long startTime = System.currentTimeMillis();
        Iterator<Integer> iterator = integerLinkedList.iterator();
        while (iterator.hasNext())
            iterator.next();
        System.out.println(System.currentTimeMillis() - startTime);

        startTime = System.currentTimeMillis();
        for (int i = 0; i < integerLinkedList.size(); i++) {
            integerLinkedList.get(i);
        }
        System.out.println(System.currentTimeMillis() - startTime);
    }
}
