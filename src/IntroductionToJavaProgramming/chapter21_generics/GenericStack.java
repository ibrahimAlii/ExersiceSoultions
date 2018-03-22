package chapter21;

import java.util.Arrays;

public class GenericStack<E> {

    private E[] list = (E[]) new Object[9];
    private int index = 0;

    public int getSize() {
        return list.length;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public E peek() {
        return list[getSize() - 1];
    }

    public void push(E o) {
        if (index++ >= getSize())
            list = (E[]) new Object[getSize() * 2];

        list[index] = o;
    }

    public E pop() {
        E o = list[index - 1];
        E[] newList = (E[]) new Object[list.length - 1];
        for (int i = 0; i < newList.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
        return o;
    }

    public boolean isEmpty() {
        return list[0] == null;
    }

    @Override
    public String toString() {
        return " " + Arrays.toString(list);
    }
}
