package chapter20;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HilbertCurve extends JApplet {

    private JTextField jtfOrder = new JTextField("0", 5); // Order
    private Curve hilerbtCurvePanel =
            new Curve(); // To display the pattern

    public HilbertCurve() {
        // Panel to hold label, text field, and a button
        JPanel panel = new JPanel();
        panel.add(new JLabel("Enter an order: "));
        panel.add(jtfOrder);
        jtfOrder.setHorizontalAlignment(SwingConstants.RIGHT);

        // Add a HilberCurve panel to the applet
        add(hilerbtCurvePanel);
        add(panel, BorderLayout.SOUTH);

        // Register a listener
        jtfOrder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hilerbtCurvePanel.setOrder(Integer.parseInt(jtfOrder.getText()));
            }
        });
    }

    private static class Curve extends JPanel {
        private int x, y; // U shape center
        private int length; // length of a U side. Dynamically determined based on order
        private int order = 1; // Order of the Hilbert curve

        /**
         * Set a new order
         */
        public void setOrder(int order) {
            this.order = order;
            repaint();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Get the length of a U side
            length = Math.min(getWidth(), getHeight());
            for (int i = 0; i < order; i++)
                length /= 2;

            // Reset start cursor position
            x = length / 2;
            y = length / 2;

            upperU(g, order); // Start recursion
        }

        /**
         * Display upper U
         */
        private void upperU(Graphics g, int order) {
            if (order > 0) {
                leftU(g, order - 1);
                lineNewPosition(g, 0, length);
                upperU(g, order - 1);
                lineNewPosition(g, length, 0);
                upperU(g, order - 1);
                lineNewPosition(g, 0, -length);
                rightU(g, order - 1);
            }
        }

        /**
         * Display left U
         */
        private void leftU(Graphics g, int order) {
            if (order > 0) {
                upperU(g, order - 1);
                lineNewPosition(g, length, 0);
                leftU(g, order - 1);
                lineNewPosition(g, 0, length);
                leftU(g, order - 1);
                lineNewPosition(g, -length, 0);
                downU(g, order - 1);
            }
        }

        /**
         * Display right U
         */
        private void rightU(Graphics g, int order) {
            if (order > 0) {
                downU(g, order - 1);
                lineNewPosition(g, -length, 0);
                rightU(g, order - 1);
                lineNewPosition(g, 0, -length);
                rightU(g, order - 1);
                lineNewPosition(g, length, 0);
                upperU(g, order - 1);
            }
        }

        /**
         * Display down U
         */
        private void downU(Graphics g, int order) {
            if (order > 0) {
                rightU(g, order - 1);
                lineNewPosition(g, 0, -length);
                downU(g, order - 1);
                lineNewPosition(g, -length, 0);
                downU(g, order - 1);
                lineNewPosition(g, 0, length);
                leftU(g, order - 1);
            }
        }

        /**
         * Draw a line from the current position to the new relative position
         */
        public void lineNewPosition(Graphics g, int deltaX, int deltaY) {
            g.drawLine(x, y, x + deltaX, y + deltaY);
            x += deltaX;
            y += deltaY;
        }
    }

    /**
     * Main method
     */
    public static void main(String[] args) {
        JApplet applet = new HilbertCurve();
        applet.init();
        applet.start();
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Exercise20_36");
        frame.getContentPane().add(applet, BorderLayout.CENTER);
        frame.setSize(512, 512);
        frame.setVisible(true);
    }
}
