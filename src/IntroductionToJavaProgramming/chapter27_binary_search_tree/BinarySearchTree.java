package IntroductionToJavaProgramming.chapter27_binary_search_tree;


import java.util.ArrayList;
import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<E>> extends AbstractTree<E> {

    protected TreeNode<E> root;
    protected int size = 0;

    public BinarySearchTree(){

    }

    public BinarySearchTree(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            insert(objects[i]);

    }

    /**
     * @param element if element is less than {current.element} assign [current.left] to @current
     *                if element is greater than {current.element} assign [current.right] to current
     *                if element is equal {current.element} @return true
     */
    @Override
    public boolean search(E element) {
        TreeNode<E> current = root; // Start from root

        while (current != null) {
            if (element.compareTo(current.element) < 0) // less than current element assign to left
                current = current.left;
            else if (element.compareTo(current.element) > 0) // greater than current element assign to right
                current = current.right;
            else return true; // element is found
        }

        return false;
    }

    @Override
    public boolean insert(E e) {
        if (root == null) {
            // Create a node for e as the root
            root = createNewNode(e);
        } else {
            // Locate the parent node
            TreeNode<E> current = root;
            TreeNode<E> parent = null;
            while (current != null) {
                if (e.compareTo(current.element) < 0) {
                    parent = current;
                    current = current.left;
                } else if (e.compareTo(current.element) > 0) {
                    parent = current;
                    current = current.right;
                } else return false; // Duplicate node not inserted


            }
            // Create the new node and attach it to the parent node
            if (e.compareTo(parent.element) < 0)
                parent.left = createNewNode(e);
            else parent.right = createNewNode(e);

        }
        size++;
        return true; // Element inserted
    }

    protected TreeNode<E> createNewNode(E e) {
        return new TreeNode<>(e);
    }

    @Override
    public void inorder() {
        inorder(root);
    }

    protected void inorder(TreeNode<E> root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    @Override
    public void postorder() {
        postorder(root);
    }

    protected void postorder(TreeNode<E> root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    @Override
    public void preorder() {
        preorder(root);
    }

    protected void preorder(TreeNode<E> root) {
        if (root == null) return;
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {
        return root;
    }

    /**
     * Return a path from the root leading to the specified element
     */
    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;

        while (current != null) {
            list.add(current);

            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else break;
        }

        return list;
    }

    /**
     * Delete an element from the binary search tree.
     * Return true if the element is deleted successfully.
     * Return false if the element is not in the tree.
     */
    @Override
    public boolean delete(E e) {
        // Locate the node to be deleted and also locate its parent node
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            } else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            } else break;
        }
        if (current == null)
            return false; // Element is not in the tree

        // Case 1: Current has no left children
        if (current.left == null) {
            // Connect the parent with the right child of the current node
            if (parent == null)
                root = current.right;
            else {
                if (e.compareTo(parent.element) < 0)
                    parent.left = current.right;
                else parent.right = current.right;
            }
        } else {
            // Case 2: The current node has a left child
            // Locate the rightmost node in the left subtree of the current node and also its parent
            TreeNode<E> parentOfRightMost = current;
            TreeNode<E> rightMost = current.left;

            while (rightMost.right != null) {
                parentOfRightMost = rightMost;
                rightMost = rightMost.right; // Keep going to the right
            }

            // Replace the element in current by the element in right most
            current.element = rightMost.element;

            // Eliminate rightmost node
            if (parentOfRightMost.right == rightMost)
                parentOfRightMost.right = rightMost.left;
            else // Special case: parentOfRightMost == current
                parentOfRightMost.left = rightMost.left;
        }

        size--;
        return true; // Element deleted
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }

    private class InorderIterator implements Iterator<E> {

        private ArrayList<E> list = new ArrayList<>();
        private int current = 0;

        public InorderIterator() {
            inorder();
        }

        private void inorder() {
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root == null) return;
            inorder(root.left);
            list.add(root.element);
            inorder(root.right);
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
            delete(list.get(current));
            list.clear();
            inorder();
        }
    }
}
