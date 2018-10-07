package IntroductionToJavaProgramming.chapter27_binary_search_tree;

import IntroductionToJavaProgramming.chapter6_arrays.BinarySearch;

import java.util.ArrayList;

public class TestBST {

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("ibrahim");
        tree.insert("Ali");
        tree.insert("rokya");
        tree.insert("hager");
        tree.insert("Asmaa");
        tree.insert("aseel");
        tree.insert("hoda");
        tree.insert("abd elrahman");
        tree.insert("Ibrahim");

        // Traverse Tree
        System.out.print("Inorder (sorted): ");
        tree.inorder();
        System.out.print("\nPostorder : ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.println("\nThe number of nodes is: " + tree.size);

        System.out.print("\nIs asmaa in the tree? " + tree.search("Asmaa"));

        // Get the path from the root to aseel
        System.out.print("\npath from root to aseel is: ");
        ArrayList<TreeNode<String>> path = tree.path("aseel");

        for (int i = 0; path != null && i < path.size(); i++)
            System.out.print(path.get(i).element + " ");

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BinarySearchTree<Integer> intTree = new BinarySearchTree<>(numbers);
        System.out.println();
        intTree.inorder();

    }
}
