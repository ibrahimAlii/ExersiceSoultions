import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AnimationBallOnCurve extends JFrame {

    BallOnCurve ballOnCurve = new BallOnCurve();
    int x = -getWidth();
    Timer timer = new Timer(300, ballOnCurve);

    public AnimationBallOnCurve() {

        add(ballOnCurve);
        ballOnCurve.requestFocus();
        timer.start();
    }

    class BallOnCurve extends JPanel implements ActionListener {

        public BallOnCurve() {

        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (x < ballOnCurve.getWidth())
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
