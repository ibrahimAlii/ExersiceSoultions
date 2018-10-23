package IntroductionToJavaProgramming.chapter27_binary_search_tree;

public class TreeNode<E extends Comparable<E>> {
   public E element;
   public TreeNode<E> left;
   public TreeNode<E> right;

    public TreeNode(E e) {
        element = e;
    }
}
