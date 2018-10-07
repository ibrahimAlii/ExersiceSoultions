package IntroductionToJavaProgramming.chapter27_binary_search_tree;


import java.util.Iterator;

public interface Tree<E extends Comparable<E>> extends Iterable<E> {

    boolean search(E e);

    boolean insert(E e);

    boolean delete(E e);

    void inorder();

    void preorder();

    void postorder();

    int getSize();

    boolean isEmpty();

    void clear();

    Iterator<E> iterator();
}
