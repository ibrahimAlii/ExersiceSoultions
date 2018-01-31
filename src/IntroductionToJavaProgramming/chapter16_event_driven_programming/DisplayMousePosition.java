package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DisplayMousePosition extends JFrame {

    public DisplayMousePosition(){

        MousePosition mousePosition = new MousePosition();

        mousePosition.setFocusable(true);

        add(new MousePosition());
    }

    class MousePosition extends JPanel{

        private int xCoordinate;
        private int yCoordinate;


        private MousePosition(){

            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {

                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    xCoordinate = e.getX();
                    yCoordinate = e.getY();

                    repaint();
                }
            });

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString(xCoordinate + ", " + yCoordinate, getWidth() / 2, getHeight() / 2);
        }
    }
}
