package IntroductionToJavaProgramming.chapter26_lists_stacks_queues;

public class Node<E> {
    E element;
    Node<E> next;

    public Node(E e) {
        element = e;
    }
}
