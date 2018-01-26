package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlCircle extends JFrame {

    JButton jEnlarge = new JButton("Enlarge");
    JButton jShrink = new JButton("Shrink");
    CirclePanel canvas = new CirclePanel();

    public ControlCircle(){
        JPanel jPanel = new JPanel();

        jPanel.add(jEnlarge);
        jPanel.add(jShrink);

        this.add(canvas, BorderLayout.CENTER);
        this.add(jPanel, BorderLayout.SOUTH);

        jEnlarge.addActionListener(new EnlargeListener());
        jShrink.addActionListener(new ShrinkListener());
    }

    class ShrinkListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.shrink();
        }
    }

    class EnlargeListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            canvas.enlarge();
        }
    }

    class CirclePanel extends JPanel{
        private int radius = 5;

        public void shrink(){
            radius--;
            repaint();
        }
        public void enlarge(){
            radius++;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawOval(getWidth() / 2 - radius, getHeight() / 2 - radius,
                    2 * radius, 2 * radius);
        }
    }
}
