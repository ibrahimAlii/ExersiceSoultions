package IntroductionToJavaProgramming.chapter27_binary_search_tree.huffman;

import IntroductionToJavaProgramming.chapter25_sorting.Heap;

public class Huffman {

    /**
     * Get Huffman codes for the characters
     * this method is called once after a huffman tree is built
     */
    public static String[] getCode(Node root) {
        if (root == null) return null;
        String[] codes = new String[2 * 128];
        assignCode(root, codes);
        return codes;
    }

    /* Recursively get codes to the leaf node */
    private static void assignCode(Node root, String[] codes) {
        if (root.left != null) {
            root.left.code = root.code + "0";
            assignCode(root.left, codes);

            root.right.code = root.code + "1";
            assignCode(root.right, codes);
        } else {
            codes[(int) root.element] = root.code;
        }
    }

    /**
     * Get a Huffman tree from the codes
     */
    public static Tree getHuffmanTree(int[] counts) {
        // Create a heap to hold trees
        Heap<Tree> heap = new Heap<>();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                heap.add(new Tree(counts[i], (char) i));
        }

        while (heap.getSize() > 1) {
            Tree t1 = heap.remove(); // Remove the smallest-weight tree
            Tree t2 = heap.remove(); // Remove the next smallest
            heap.add(new Tree(t1, t2));
        }

        return heap.remove(); // The final tree
    }

    /**
     * Get the frequency of characters
     */
    public static int[] getCharacterFrequency(String text) {
        int[] counts = new int[256]; // 256 ASCII character http://www.asciitable.com/

        for (int i = 0; i < text.length(); i++)
            counts[(int) text.charAt(i)]++; // Count the characters in the text

        return counts;
    }
}
