package sample;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by sun_m on 05/02/2018.
 */
public class SlideShow extends JFrame {

    private JButton next, prev;
    private Slider slider;

    public SlideShow() {

        next = new JButton("Next");
        prev = new JButton("Previous");
        slider = new Slider();


        add(slider, BorderLayout.CENTER);
        add(next, BorderLayout.NORTH);
        add(prev, BorderLayout.NORTH);
    }

    class Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == next)
                slider.nextImg();
            else if (e.getSource() == prev)
                slider.prevImg();

            repaint();
        }
    }

    class Slider extends JPanel {

        private int currentImgIndex = 0;

        private void nextImg() {
            currentImgIndex++;
        }

        private void prevImg() {
            currentImgIndex--;
        }


        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            Image image = new ImageIcon("somepath" + currentImgIndex).getImage();
            g.drawImage(image, getWidth() / 2,
                    getHeight() / 2, this);
        }
    }
}
