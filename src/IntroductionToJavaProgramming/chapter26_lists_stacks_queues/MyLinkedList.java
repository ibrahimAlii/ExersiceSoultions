package IntroductionToJavaProgramming.chapter26_lists_stacks_queues;


import java.util.Iterator;

public class MyLinkedList<E> extends MyAbstractList<E> {
    private Node<E> head, tail;

    /**
     * Create a default list
     */
    public MyLinkedList() {
    }

    /**
     * Create a list from an array of objects
     */
    public MyLinkedList(E[] objects) {
        super(objects);
    }

    /**
     * Return the head element in the list
     */
    public E getFirst() {
        if (size == 0)
            return null;
        else return head.element;
    }

    /**
     * Return the last element in the list
     */
    public E getLast() {
        if (size == 0)
            return null;
        else return tail.element;
    }

    /**
     * Add an element to the beginning of the list
     */
    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        newNode.next = head; // Link the new node with the head
        head = newNode; // head points to the new node
        size++; // Increase the size

        if (tail == null) // The new node is only node in list
            tail = head;
    }

    /**
     * Add an element to the last of the list
     */
    public void addLast(E e) {
        Node<E> newNode = new Node<>(e); // Create a new node
        if (tail == null)
            head = tail = newNode; // The only node in list
        else {
            tail.next = newNode; // Link the new with the last node
            tail = tail.next; // tail now points to the last node
        }

        size++; // Increase size
    }

    @Override
    public void add(int index, E element) {
        if (index == 0) addFirst(element); // Insert first
        else if (index >= size) addLast(element); // Insert last
        else { // Not in the first nor in the last
            Node<E> current = head;
            for (int i = 0; i < index; i++)
                current = current.next;

            Node<E> temp = current.next;
            current.next = new Node<>(element);
            (current.next).next = temp;

            size++;
        }
    }

    public E removeFirst() {
        if (size == 0) return null; // No thing to delete
        else {
            Node<E> temp = head;
            head = head.next; // Move head to point to next node
            size--;
            if (head == null) tail = null; // List become empty
            return temp.element;
        }
    }

    public E removeLast() {
        if (size == 0) return null; // No thing to remove
        else if (size == 1) { // Only one element in the list
            Node<E> temp = head;
            head = tail = null; // List become empty
            size = 0;
            return temp.element;
        } else {
            Node<E> current = head;

            for (int i = 0; i < size - 2; i++)
                current = current.next;

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            size--;
            return temp.element;
        }
    }

    public E remove(int index) {
        if (index < 0 || index >= size) return null; // Out of range
        else if (index == 0) return removeFirst(); // Remove first
        else if (index == size - 1) return removeLast(); // Remove last
        else {
            Node<E> previous = head;

            for (int i = 0; i < index; i++)
                previous = previous.next;

            Node<E> current = previous.next;
            previous.next = current.next;
            size--;
            return current.element;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");

        Node<E> current = head;
        for (int i = 0; i < size; i++) {
            result.append(current.element);
            current = current.next;
            if (current != null)
                result.append(", ");
            else result.append("]");
        }
        return result.toString();
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(E element) {
        // TODO: 04/10/2018  
        return false;
    }

    @Override
    public E get(int index) {
        // TODO: 04/10/2018  
        return null;
    }

    @Override
    public int indexOf(E element) {
        // TODO: 04/10/2018  
        return 0;
    }

    @Override
    public int lastIndexOf(E element) {
        // TODO: 04/10/2018  
        return 0;
    }


    @Override
    public Object set(int index, E element) {
        // TODO: 04/10/2018  
        return null;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }
    
    private class LinkedListIterator implements Iterator<E>{
        private Node<E> current = head;
        
        @Override
        public boolean hasNext() {
            return (current != null);
        }

        @Override
        public E next() {
            E e = current.element;
            current = current.next;
            return e;
        }

        @Override
        public void remove() {
            // TODO: 04/10/2018
        }
    }
}
