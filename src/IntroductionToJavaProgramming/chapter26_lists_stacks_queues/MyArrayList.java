package IntroductionToJavaProgramming.chapter26_lists_stacks_queues;

import java.util.Iterator;

public class MyArrayList<E> extends MyAbstractList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = ((E[]) new Object[INITIAL_CAPACITY]);


    /**
     * Create a default list
     */
    public MyArrayList() {
    }

    /**
     * Create a list from an array of objects
     */
    public MyArrayList(E[] objects) {
        for (E object : objects) add(object);
    }

    @Override // Add a new element at the specified index
    public void add(int index, E element) {
        ensureCapacity();

        // Move the element to the right after the specified index
        for (int i = size - 1; i >= index; i--)
            data[i + 1] = data[i];

        // Insert new element to data[index]
        data[index] = element;

        // Increase size by 1
        size++;
    }

    /**
     * Create a new array double the current size +1
     */
    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) (new Object[size * 2 + 1]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override // Clear the list
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override // Return true if this list contain the element
    public boolean contains(E element) {
        for (int i = 0; i < size; i++)
            if (element.equals(data[i])) return true;

        return false;
    }

    @Override // Return the element at the specified index
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }

    @Override // Return the index of the first matching element in this list. Return -1 if no match
    public int indexOf(E element) {
        for (int i = 0; i < size; i++)
            if (element.equals(data[i])) return i;

        return -1;
    }

    @Override // Return the index of the last matching element in this lis. Return -1 if no match
    public int lastIndexOf(E element) {
        for (int i = size; i >= 0; i--)
            if (element.equals(data[i])) return i;

        return -1;
    }

    @Override // Remove the element at the specified position in this list. Shift any subsequent elements to the lef
    // Return the element that was removed from the list
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];

        // Shift data to the left
        for (int i = 0; i < size - 1; i++)
            data[i] = data[i + 1];

        data[size - 1] = null; // This element is now null

        // Decrement size
        size--;

        return e;
    }


    @Override
    /** Replace the element at the specified position in this list with the specified element
     */
    public Object set(int index, E element) {
        checkIndex(index);
        E old = data[index];

        data[index] = element;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(", ");
        }

        return result.toString() + "]";
    }

    /**
     * Trim the capacity to current size
     */
    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[]) (new Object[size]);
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        } // if size == capacity, no need to trim
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return (current < size);
        }

        @Override
        public E next() {
            return data[current++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(current);
        }
    }
}
