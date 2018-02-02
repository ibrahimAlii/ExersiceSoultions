package IntroductionToJavaProgramming.chapter16_event_driven_programming;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayRunningFan extends JFrame {




    public DisplayRunningFan() {


        add(new Fan());

    }

    class Fan extends JPanel {
        private int xCenter, yCenter;
        private int fanRadius, bladeLength;
        private int angle = 100;
        private int direction = 1;
        private int speed = 10;
        private Timer timer = new Timer(speed, new TimerListener());

        private Fan() {
            timer.start();
        }

        public void reverse() {
            direction = -direction;
        }

        public void setSpeed(int ms) {
            speed = ms;
            timer.setDelay(speed);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Set clock radius, and center
            fanRadius = (int) (Math.min(getSize().width, getSize().height) * 0.9 * 0.5);
            xCenter = (getSize().width) / 2;
            yCenter = (getSize().height) / 2;
            bladeLength = (int) (fanRadius * 0.9);
            angle = (angle + direction) % 360;

            // Draw circle
            g.setColor(Color.black);
            g.drawOval(xCenter - fanRadius, yCenter - fanRadius,
                    2 * fanRadius, 2 * fanRadius);

            // Draw four blades
            drawBlade(g, angle);
            drawBlade(g, angle + 90);
            drawBlade(g, angle + 180);
            drawBlade(g, angle + 270);
        }

        private void drawBlade(Graphics g, int angle) {
            g.setColor(Color.red);
            g.fillArc(xCenter - bladeLength, yCenter - bladeLength,
                    2 * bladeLength, 2 * bladeLength, angle, 30);
        }


        class TimerListener implements ActionListener {

            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        }
    }
}
