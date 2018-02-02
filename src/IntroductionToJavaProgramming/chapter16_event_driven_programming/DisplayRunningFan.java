package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import IntroductionToJavaProgramming.chapter10_ThinkingInObjects.Time;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DisplayRunningFan extends JFrame {

    private Fan fan;
    public DisplayRunningFan(){
        fan = new Fan();
        add(fan);

        //Timer timer = new Timer(1000, new TimerListener());

        //timer.start();
    }

    class Fan extends JPanel{

        private int xCenter = getWidth() / 2;
        private int yCenter = getHeight() / 2;
        private int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);

        private int x = xCenter - radius;
        private int y = yCenter - radius;



        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawArc(x, y, 2 * radius, 2 * radius, 0, 30);
            for (int i = 0; i < 4; i++) {
                int startAngel = (int) (Math.random() * 360);
                int arcAngel = (int) (Math.random() * 360);
                g.fillArc(x, y, 2 * radius, 2 * radius, startAngel, arcAngel);
            }
        }


    }

    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            fan.repaint();
        }
    }
}
