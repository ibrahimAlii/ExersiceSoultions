package IntroductionToJavaProgramming.chapter26_lists_stacks_queues;


public interface MyList<E> extends Iterable<E> {

    /** Add a new element at the end of this list */
    public void add(E element);



    /** Add a new element at the specified index in this list */
    public void add(int index, E element);



    /** Clear the list */
    public void clear();



    /** Return true if this list contains the element */
    public boolean contains(E element);



    /** Return the element from this list at specific index */
    public E get(int index);



    /** Return the index of the first matching element in this list. Return -1 if no match */
    public int indexOf(E element);



    /** Return true if this list doesn't contain any elements */
    public boolean isEmpty();



    /** Return the index of the last matching element in this list. Return -1 if no match */
    public int lastIndexOf(E element);



    /** Remove the first occurrence of the element e from this list .
     *  Shift any subsequent elements to the left.
     *  Return true if the element is removed
     */
    public boolean remove(E element);



    /** Remove the element at the specified position in this list.
     *  Shift any subsequent elements to the left.
     *  Return the element that was removed from the list.
     */
    public E remove(int index);



    /** Replace the element at the specified position in this list
     *  with the specified element and return the old element
     */
    public Object set(int index, E element);



    /** Return the number of elements in this list */
    public int size();
}
