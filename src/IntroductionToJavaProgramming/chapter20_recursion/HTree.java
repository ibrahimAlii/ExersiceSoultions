package IntroductionToJavaProgramming.chapter20_recursion;

import javax.swing.*;
import java.awt.*;

public class HTree extends JFrame {

    private H h = new H();

    public HTree() {
        add(h);
    }

    public static void main(String[] args) {
        JFrame frame = new HTree();
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    class H extends JPanel {

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(400, 400);
        }

        public H() {

        }

        private int xCenter = getWidth() / 2;
        private int yCenter = getHeight() / 2;
        private int width = 400;
        private int height = 400;

        private Point point1 = new Point(80, 40);
        private Point point2 = new Point(80, height - 80);
        private Point point3 = new Point(width - 80, 40);
        private Point point4 = new Point(width - 80, height - 80);
        int level = 4;

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            drawHTree(g, level, 400, 400, 300);
        }

        public void drawH(int x, int y, int size, Graphics g) {

            // compute the coordinates of the 4 tips of the H
            int x0 = (x - size / 2);
            int x1 = (x + size / 2);
            int y0 = (y - size / 2);
            int y1 = (y + size / 2);

            // draw the 3 line segments of the H
            g.drawLine(x0, y0, x0, y1);    // left  vertical segment of the H
            g.drawLine(x1, y0, x1, y1);    // right vertical segment of the H
            g.drawLine(x0, y, x1, y);    // connect the two vertical segments of the H
        }

        private void drawHTree(Graphics g, int level, int x, int y, int size) {

            if (level == 0) return;
            drawH(x, y, size, g);

            // compute x- and y-coordinates of the 4 half-size H-trees
            int x0 = x - size / 2;
            int x1 = x + size / 2;
            int y0 = y - size / 2;
            int y1 = y + size / 2;

            // recursively draw 4 half-size H-trees of order n-1
            drawHTree(g, level - 1, x0, y0, size / 2);    // lower left  H-tree
            drawHTree(g, level - 1, x0, y1, size / 2);    // upper left  H-tree
            drawHTree(g, level - 1, x1, y0, size / 2);    // lower right H-tree
            drawHTree(g, level - 1, x1, y1, size / 2);    // upper right H-tree
        }
    }


}
