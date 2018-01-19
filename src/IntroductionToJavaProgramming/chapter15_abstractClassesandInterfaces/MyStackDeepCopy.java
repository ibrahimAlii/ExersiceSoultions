package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import java.util.ArrayList;

public class MyStackDeepCopy implements Cloneable {

    private ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(getSize() - 1);
    }

    public Object pop() {
        Object o = list.get(getSize() - 1);
        list.remove(getSize() - 1);
        return o;
    }

    public void push(Object o) {
        list.add(o);
    }

    /** Override the toString in the Object class */
    public String toString() {
        return "stack: " + list.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        MyStackDeepCopy stack = (MyStackDeepCopy) super.clone();
        stack.list = (ArrayList<Object>) this.list.clone();
        return stack;
    }
}
