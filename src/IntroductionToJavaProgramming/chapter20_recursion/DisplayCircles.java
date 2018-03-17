package chapter20;

import javax.swing.*;
import java.awt.*;

public class DisplayCircles extends JFrame {

    Circles circles = new Circles();

    public DisplayCircles() {
        add(circles);
    }

    public static void main(String[] args) {
        JFrame frame = new DisplayCircles();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class Circles extends JPanel {


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            int radius = (int)(Math.min(getWidth(), getHeight()) * 0.9 / 2);
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            drawCircles(g, radius, centerX, centerY);
        }

        private void drawCircles(Graphics g, int radius,
                                 int centerX, int centerY) {

            if (radius >= 5) {
                g.drawOval(centerX - radius, centerY - radius, 2 * radius,
                        2 * radius);

                drawCircles(g, radius - 5, centerX, centerY);
            }

        }

        private Point midPoint(Point point) {
            return new Point(point.x / 2, point.y / 2);
        }
    }
}
