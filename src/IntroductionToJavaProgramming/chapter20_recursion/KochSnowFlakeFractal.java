package IntroductionToJavaProgramming.chapter20_recursion;

import javax.swing.*;
import java.awt.*;

public class KochSnowFlakeFractal extends JFrame {

    KochFractal kochFractal = new KochFractal();

    public KochSnowFlakeFractal() {

        add(kochFractal);
    }


    public static void main(String[] args) {
        JFrame frame = new KochSnowFlakeFractal();
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    class KochFractal extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);


            Point p1 = new Point(getWidth() / 2, 10);
            Point p2 = new Point(10, getHeight() - 10);
            Point p3 = new Point(getWidth() - 10, getHeight() - 10);

            drawFractal(g, p1, p2, p3, 4);
        }

        private void drawFractal(Graphics g, Point p1, Point p2, Point p3, int count) {
            drawFractal(g, p1, p2, count);    // draw 3 lines to make a triangle
            drawFractal(g, p2, p3, count);
            drawFractal(g, p3, p1, count);
        }

        private void drawFractal(Graphics g, Point p1, Point p2, int count) {
            if (count == 0) {
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
            if (count >= 1) {
                Point distance = new Point((p2.x - p1.x) / 3, (p2.y - p1.y) / 3);
                Point pA = new Point(p1.x + distance.x, p1.y + distance.y);
                Point pB = new Point(p2.x - distance.x, p2.y - distance.y);
                double sin60 = -0.866025403784438646763723170752936183471402626905190;
                Point pTip = new Point(
                        pA.x + (int) (distance.x * 0.5 + distance.y * sin60),
                        pA.y + (int) (distance.y * 0.5 - distance.x * sin60)
                );

                drawFractal(g, p1, pA, count - 1);    // if level 1 or higher,
                drawFractal(g, pA, pTip, count - 1);    // recursively call self 4 times
                drawFractal(g, pB, p2, count - 1);
                drawFractal(g, pTip, pB, count - 1);
            }
        }
    }
}
