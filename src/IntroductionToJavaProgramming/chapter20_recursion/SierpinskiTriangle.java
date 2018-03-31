package IntroductionToJavaProgramming.chapter20_recursion;

import javax.swing.*;
import java.awt.*;

public class SierpinskiTriangle extends JFrame {

    private JTextField textField = new JTextField("0", 5);
    private SierpinskiTrianglePanel trianglePanel =
            new SierpinskiTrianglePanel();


    public SierpinskiTriangle(){
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter and order: "));
        panel.add(textField);
        textField.setHorizontalAlignment(SwingConstants.RIGHT);

        add(trianglePanel);
        add(panel, BorderLayout.SOUTH);

        textField.addActionListener(e -> trianglePanel.setOrder(Integer.parseInt(textField.getText())));
    }
    public static void main(String[] strings) {

        JFrame frame = new SierpinskiTriangle();
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }


    static class SierpinskiTrianglePanel extends JPanel {

        private int order = 0;

        /**
         * Set a new order
         */
        public void setOrder(int order) {
            this.order = order;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);


            Point p1 = new Point(getWidth() / 2 , 10);
            Point p2 = new Point(10 , getHeight() - 10);
            Point p3 = new Point(getWidth() - 10 , getHeight() - 10);

            displayTriangles(g, order, p1, p2, p3);
        }

        private static void displayTriangles(Graphics g, int order,
                                             Point point1, Point point2, Point point3) {


            if (order == 0) {
                g.drawLine(point1.x, point1.y, point2.x, point2.y);
                g.drawLine(point1.x, point1.y, point3.x, point3.y);
                g.drawLine(point2.x, point2.y, point3.x, point3.y);
            }else {

                Point p1 = midPoint(point1, point2);
                Point p2 = midPoint(point2, point3);
                Point p3 = midPoint(point1, point3);

                displayTriangles(g, order - 1, point1, p1, p3);
                displayTriangles(g, order - 1, p1, point2, p2);
                displayTriangles(g, order - 1, p3, p2, point3);
            }
        }

        private static Point midPoint(Point point1, Point point2){
            return new Point((point1.x + point2.x) / 2, (point1.y + point2.y) / 2);
        }

    }
}
