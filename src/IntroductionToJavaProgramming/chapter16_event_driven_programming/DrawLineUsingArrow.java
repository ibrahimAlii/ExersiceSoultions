package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javafx.scene.shape.Polyline;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class DrawLineUsingArrow extends JFrame{


    public DrawLineUsingArrow(){

        MovingLine movingLine = new MovingLine();

        add(movingLine);

        // Set focus
        movingLine.setFocusable(true);

    }

    class MovingLine extends JPanel{
        private int xCoordinate = getWidth() / 2;
        private int yCoordinate = getHeight() / 2;
        private int oldX = getHeight() / 2;
        private int oldY = getHeight() / 2;
        private char charKey = 'A';



        public MovingLine(){

            addKeyListener(new KeyAdapter() {
                @Override
                public void keyPressed(KeyEvent e) {
                    switch (e.getKeyCode()){
                        case KeyEvent.VK_UP: yCoordinate -= 10; break;
                        case KeyEvent.VK_DOWN: yCoordinate += 10; break;
                        case KeyEvent.VK_LEFT: xCoordinate -= 10; break;
                        case KeyEvent.VK_RIGHT: xCoordinate += 10; break;
                        default: charKey = e.getKeyChar();
                    }

                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {

            super.paintComponent(g);
            g.drawLine(oldX, oldY, xCoordinate, yCoordinate);

            oldX = xCoordinate;
            oldY = yCoordinate;
        }
    }
}
