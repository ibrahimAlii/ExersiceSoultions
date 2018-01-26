package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class MoveMessageDemo extends JFrame {

    public MoveMessageDemo(){
        //Create a MoveAbleMessage instance for moving a message
        MoveAbleMessage panel = new MoveAbleMessage("Test");

        add(panel);
    }

    static class MoveAbleMessage extends JPanel{
        private String message = "Welcome to Java";
        private int x = 20;
        private int y = 20;

        public MoveAbleMessage(String s){
            message = s;
            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    //Get the new location and repaint() the screen
                    x = e.getX();
                    y = e.getY();
                    repaint();
                }

                @Override
                public void mouseMoved(MouseEvent e) {

                }
            });

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(message, x, y);
        }
    }
}
