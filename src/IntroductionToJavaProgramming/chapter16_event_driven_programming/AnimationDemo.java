package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AnimationDemo extends JFrame {

    public AnimationDemo(String message){
        this.setLayout(new GridLayout(2, 1));
        add(new MovingMessagePanel(message));
        add(new MovingMessagePanel(message));
    }


    static class MovingMessagePanel extends JPanel{

        private String message = "Welcome to Java";
        private int xCoordinate = 0;
        private int yCoordinate = 20;
        private Timer timer = new Timer(1000, new TimerListener());

        public MovingMessagePanel(String message){
            this.message = message;

            //Start timer for animation
            timer.start();


            //Control animation
            this.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int delay = timer.getDelay();
                    if (e.getButton() == MouseEvent.BUTTON1)
                        timer.setDelay(delay > 10 ? delay - 10 : 0);
                    else if (e.getButton() == MouseEvent.BUTTON3)
                        timer.setDelay(delay < 50000 ? delay + 10 : 50000);
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (xCoordinate > getWidth()){
                xCoordinate = -20;
            }
            xCoordinate += 5;
            g.drawString(message, xCoordinate, yCoordinate);
        }

        class TimerListener implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
    }
}
