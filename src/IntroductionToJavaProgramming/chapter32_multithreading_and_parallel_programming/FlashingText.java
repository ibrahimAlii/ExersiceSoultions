package IntroductionToJavaProgramming.chapter32_multithreading_and_parallel_programming;

import javax.swing.*;
import java.awt.*;

public class FlashingText extends JFrame implements Runnable {
    private JLabel label = new JLabel("Flashing Text", JLabel.CENTER);

    public FlashingText() {
        add(label);
        new Thread(this).start();
    }

    public static void main(String[] main) {
        Frame frame = new FlashingText();
        frame.setSize(300, 300);
        ((FlashingText) frame).setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    @Override
    public void run() {
        try {
            while (true) {
                if (label.getText() == null)
                    label.setText("Flashing Text");
                else label.setText(null);

                Thread.sleep(200);
            }
        } catch (InterruptedException ex) {

        }
    }
}
