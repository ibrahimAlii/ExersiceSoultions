package IntroductionToJavaProgramming.chapter27_binary_search_tree.huffman;

public class Node {
    char element; // Store the character for a leaf node.
    int weight; // weight of the subtree rooted at this node
    Node left; // Reference to the left subtree
    Node right; // Reference to the right subtree
    String code = ""; // The code of this node from the root;

    public Node() {

    }

    /**
     * Create a node with specified weight and character
     */
    public Node(int weight, char element) {
        this.weight = weight;
        this.element = element;
    }
}
