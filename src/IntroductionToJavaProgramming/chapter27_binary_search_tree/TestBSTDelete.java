package IntroductionToJavaProgramming.chapter27_binary_search_tree;

public class TestBSTDelete {

    public static void main(String[] args) {
        BinarySearchTree<String> tree = new BinarySearchTree<>();
        tree.insert("Abd elrahman");
        tree.insert("Ibrahim");
        tree.insert("Ali");
        tree.insert("Hoda");
        tree.insert("Asmaa");
        tree.insert("Hagar");
        tree.insert("Rokya");
        tree.insert("Aseel");
        printTree(tree);

        System.out.println("\nAfter delete Aseel");
        tree.delete("Aseel");
        printTree(tree);

        System.out.println("\nAfter delete Ibrahim");
        tree.delete("Ibrahim");
        printTree(tree);
    }

    public static void printTree(BinarySearchTree tree){
        System.out.print("Inorder sorted: ");
        tree.inorder();
        System.out.print("\nPostorder: ");
        tree.postorder();
        System.out.print("\nPreorder: ");
        tree.preorder();
        System.out.print("\nThe number of nodes is " + tree.size + "\n");
    }
}
