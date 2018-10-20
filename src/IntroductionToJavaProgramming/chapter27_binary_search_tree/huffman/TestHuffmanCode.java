package IntroductionToJavaProgramming.chapter27_binary_search_tree.huffman;

import java.util.Scanner;

public class TestHuffmanCode {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = input.nextLine();

        int[] counts = Huffman.getCharacterFrequency(text);

        System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");

        Tree tree = Huffman.getHuffmanTree(counts);
        String[] codes = Huffman.getCode(tree.root);

        for (int i = 0; i < codes.length; i++) {
            if (counts[i] != 0)
                System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char) i + "", counts[i], codes[i]);
        }
    }
}
