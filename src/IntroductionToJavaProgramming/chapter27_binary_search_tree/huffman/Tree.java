package IntroductionToJavaProgramming.chapter27_binary_search_tree.huffman;

public class Tree implements Comparable<Tree> {
    Node root; // The root of the tree

    public Tree(Tree t1, Tree t2) {
        root = new Node();
        root.left = t1.root;
        root.right = t2.root;
        root.weight = t1.root.weight + t2.root.weight;
    }

    /**
     * Create a tree containing a leaf node
     */
    public Tree(int weight, char element) {
        root = new Node(weight, element);
    }

    /**
     * Compare trees based on their weights
     */
    @Override
    public int compareTo(Tree o) {
        if (root.weight < o.root.weight)
            return 1;
        else if (root.weight == o.root.weight)
            return 0;
        else return -1;
    }
}
