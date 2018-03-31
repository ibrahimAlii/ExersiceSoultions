package IntroductionToJavaProgramming.chapter22_lists_stacks_queues.bouncingballs;

import IntroductionToJavaProgramming.chapter22_lists_stacks_queues.bouncingballs.BallControl;
import bouncingballs.BallsControl;

import javax.swing.*;

public class MultipleBallApp extends JFrame {

    public MultipleBallApp(){
        add(new BallControl());
    }

    public static void main(String[] args){
        JFrame frame = new MultipleBallApp();
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
