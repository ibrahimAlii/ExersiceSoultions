package IntroductionToJavaProgramming.chapter30_graphs_and_applications.connected_circles;

import javax.swing.*;

public class DisplayConnectedCircles {

    public static void main(String[] args){
        JFrame frame = new ConnectedCircles();
        frame.setVisible(true);
        frame.setSize(600, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
