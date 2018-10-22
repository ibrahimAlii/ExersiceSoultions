package IntroductionToJavaProgramming.chapter28_hashing.set;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class HashSet<E> implements Set<E> {

    // Define the default hash-table size. Must be a power of 2
    private static int DEFAULT_INITIAL_CAPACITY = 4;

    // Define the maximum hash-table size. 1 << 30 is the same as 2^30
    private static int MAXIMUM_CAPACITY = 1 << 30;

    // Current hash-table capacity. Capacity is a power of 2
    private int capacity;

    // Define default load factor
    private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    // Specify a load-factor threshold used in the hash table
    private float loadFactorThreshold;

    // The number of elements in the set
    private int size = 0;

    // Hash table is an array with each cell being a linked list
    private LinkedList<E>[] table;

    public HashSet() {
        this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }

    public HashSet(int capacity) {
        this(capacity, DEFAULT_MAX_LOAD_FACTOR);
    }

    public HashSet(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            this.capacity = MAXIMUM_CAPACITY;
        else this.capacity = trimToPowerOf2(initialCapacity);

        this.loadFactorThreshold = loadFactorThreshold;

        table = new LinkedList[capacity];
    }

    @Override
    public void clear() {
        size = 0;
        removeElements();
    }

    @Override
    public boolean contains(E e) {
        int bucketIndex = hash(e.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<E> bucket = table[bucketIndex];
            for (E element : bucket) {
                if (element.equals(e))
                    return true;
            }
        }
        return false;
    }

    @Override
    public boolean add(E e) {
        if (contains(e)) // Duplicate element no stored
            return false;

        if (size > capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");

            rehash();
        }

        int bucketIndex = hash(e.hashCode());

        if (table[bucketIndex] == null)
            table[bucketIndex] = new LinkedList<>();

        table[bucketIndex].add(e);

        size++;

        return true;
    }

    @Override
    public boolean remove(E e) {
        if (!contains(e))
            return false;

        int bucketIndex = hash(e.hashCode());

        if (table[bucketIndex] != null) {
            LinkedList<E> bucket = table[bucketIndex];
            for (E element : bucket) {
                if (e.equals(element)) {
                    bucket.remove(element);
                    break;
                }
            }
        }
        size--;
        return true;
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
    public Iterator<E> iterator() {
        return new MyHashIterator(this);
    }

    private class MyHashIterator implements Iterator<E> {
        private ArrayList<E> list;
        private int current;
        private HashSet<E> set;

        public MyHashIterator(HashSet<E> set) {
            this.set = set;
            list = setToList();
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            set.remove(list.get(current));
            list.remove(current);
        }
    }


    /* Hash Function */
    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity - 1);
    }

    /* Ensure the hashing is evenly distributed */
    private int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1; // Same as [capacity *= 2 ] but [<<=] is more efficient

        return capacity;
    }

    /**
     * Remove all e from each bucket
     */
    private void removeElements() {
        for (int i = 0; i < capacity; i++)
            if (table[i] != null)
                table[i].clear();
    }

    /* Rehash the map */
    private void rehash() {
        java.util.ArrayList<E> set = setToList();
        capacity <<= 1;
        table = new LinkedList[capacity];
        size = 0;

        for (E e : set) {
            add(e);
        }
    }

    private ArrayList<E> setToList() {
        ArrayList<E> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                list.addAll(table[i]);
        }
        return list;
    }

    @Override
    public String toString() {
        ArrayList<E> list = setToList();
        StringBuilder builder = new StringBuilder("[");

        for (E aList : list) {
            builder.append(aList).append(", ");
        }

        if (list.size() == 0)
            builder.append("]");
        else builder.append(list.get(list.size() - 1)).append("]");

        return builder.toString();
    }
}
