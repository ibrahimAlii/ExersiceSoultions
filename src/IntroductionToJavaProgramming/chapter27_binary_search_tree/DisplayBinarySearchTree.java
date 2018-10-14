package IntroductionToJavaProgramming.chapter27_binary_search_tree;

import javax.swing.*;

public class DisplayBinarySearchTree extends JFrame {

    public DisplayBinarySearchTree(){
        add(new TreeControl(new BinarySearchTree<>()));
    }

    public static void main(String[] args){
        JFrame frame = new DisplayBinarySearchTree();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

}
