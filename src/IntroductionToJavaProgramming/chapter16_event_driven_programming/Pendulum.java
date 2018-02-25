import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Pendulum extends JFrame {

    Ball ball = new Ball();
    int x = -getWidth();
    Timer timer = new Timer(300, ball);

    public Pendulum() {

        add(ball);
        ball.requestFocus();
        timer.start();
    }

    class Ball extends JPanel implements ActionListener {

        public Ball() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (x < ball.getWidth())
                x += 1;
            else x = -getWidth();

            repaint();

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine(getWidth() / 2, 0, (int) (getWidth() * Math.sin((x / 100.0) * 2 * Math.PI)), getHeight() - 90);
            g.fillOval((int) (getWidth() * Math.sin((x / 100.0) * 2 * Math.PI)), getHeight() - 90, 20, 20);


        }
    }
}
