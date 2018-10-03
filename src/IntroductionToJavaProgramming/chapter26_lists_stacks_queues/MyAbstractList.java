package IntroductionToJavaProgramming.chapter26_lists_stacks_queues;

public abstract class MyAbstractList<E> implements MyList<E> {
    protected int size = 0;

    /**
     * Create a default list
     */
    protected MyAbstractList() {

    }

    /**
     * Create a list from an array of objects
     */
    protected MyAbstractList(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    @Override
    public void add(E element) {
        add(size, element);
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(E element) {
        if (indexOf(element) >= 0) {
            remove(indexOf(element));
            return true;
        } else return false;
    }
}
