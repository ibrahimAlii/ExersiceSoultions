package IntroductionToJavaProgramming.chapter28_hashing.set;

import java.util.Iterator;

public interface Set<E> extends Iterable<E> {

    /* Remove all elements from this set */
    void clear();

    /* Return true if the element is in the set */
    boolean contains(E e);

    /* Add the element to the set and returns true if the element is added successfully */
    boolean add(E e);

    /* Remove the element from the set and returns true if the set contained the element */
    boolean remove(E e);

    /* Return true if this set doesn't contain any elements */
    boolean isEmpty();

    /* Return the number of elements in this set */
    int size();

    /* Return an iterator for the elements in this set */
    Iterator<E> iterator();
}
