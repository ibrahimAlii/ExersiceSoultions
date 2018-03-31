package IntroductionToJavaProgramming.chapter18_appletsAndMultimedia;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Time;
import java.util.Date;
import java.util.Random;

public class TemperatureHistogram extends JApplet {

    public TemperatureHistogram() {
        add(new Histogram());
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension(400,200);
    }

    class Histogram extends JPanel {
        private double temperature[] = new double[24];
        private boolean firstTime = true;
        private double newTemp;
        private int current = 23;
        private int interval, width, individualWidth, height;

        public Histogram() {

            for (int i = 0; i < temperature.length; i++) {
                temperature[i] = new Random().nextDouble() * 40 + 50;
            }

            Timer timer = new Timer(800, new Listener());
            timer.start();
        }


        @Override
        protected void paintComponent(Graphics g) {
//            super.paintComponent(g);

            width = getSize().width;
            height = getSize().height;

            interval = (width - 40) / 24;
            individualWidth = (int) (((width - 40) / 24) * 0.60);

            if (firstTime) {
                firstTime = false;

                int x = 30;

                for (int i = 0; i < 24; i++) {
                    // g.drawRect(x, height-45-(int)temperature[i], individualWidth, (int)temperature[i]);
                    g.drawString(i + "", x, height - 35);
                    x += interval;
                }

                FontMetrics fm = g.getFontMetrics();
                String title = "Current Time: " + new Date();
                g.drawLine(10, height - 45, width - 10, height - 45);
                g.drawString(title, (width - fm.stringWidth(title)) / 2, height - 20);
            } else {
                int previous = (current - 1 + 24) % 24;
                g.setColor(getBackground()); //Color.white);
                g.fillRect(interval * previous + 30, height - 45 - (int) temperature[previous],
                        individualWidth, (int) temperature[previous]);

                g.setColor(Color.black);
                g.drawRect(interval * previous + 30, height - 45 - (int) temperature[previous],
                        individualWidth, (int) temperature[previous]);

                g.setColor(getBackground());
                g.drawRect(interval * current + 30, height - 45 - (int) temperature[current],
                        individualWidth, (int) temperature[current]);

                g.setColor(Color.red);
                temperature[current] = newTemp;
                g.fillRect(interval * current + 30, height - 45 - (int) temperature[current],
                        individualWidth, (int) temperature[current]);
            }

        }

        class Listener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                current = (current + 1) % 24;
                newTemp = (int) (Math.random() * 40 + 50);
                repaint();
            }
        }
    }


}
