package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MoveTheBall extends JFrame {

    private final JButton down;
    private final JButton up;
    private final JButton left;
    private final JButton right;
    private final Ball ball = new Ball();

    public MoveTheBall(){

        JPanel panel = new JPanel();
        right = new JButton("Right");
        left = new JButton("Left");
        up = new JButton("Up");
        down = new JButton("down");

        panel.add(right);
        panel.add(down);
        panel.add(up);
        panel.add(left);

        this.add(ball, BorderLayout.CENTER);
        this.add(panel, BorderLayout.SOUTH);

        right.addActionListener(new Listener());
        left.addActionListener(new Listener());
        up.addActionListener(new Listener());
        down.addActionListener(new Listener());



    }

    class Listener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == right)
                ball.moveRight();
            else if (e.getSource() == left)
                ball.moveLeft();
            else if (e.getSource() == up)
                ball.moveUp();
            else if (e.getSource() == down)
                ball.moveDown();
        }
    }

    class Ball extends JPanel{

        private int xCoordinate = getWidth() / 2;
        private int yCoordinate = getHeight() / 2;
        private int radius = 5;

        public void moveRight(){
            xCoordinate++;
            repaint();
        }
        public void moveLeft(){
            xCoordinate--;
            repaint();
        }
        public void moveUp(){
            yCoordinate--;
            repaint();
        }
        public void moveDown(){
            yCoordinate++;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(xCoordinate, yCoordinate,
                    2 * radius, 2 * radius);
        }
    }
}
