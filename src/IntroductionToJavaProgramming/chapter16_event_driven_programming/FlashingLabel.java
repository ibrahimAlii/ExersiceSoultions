import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlashingLabel extends JFrame {

    Label label = new Label();
    boolean isVisible = false;

    public FlashingLabel() {

        add(label);


        Timer timer = new Timer(500, new TimerListener());
        timer.start();
    }

    class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            if (isVisible) {
                isVisible = false;
                label.setVisible(false);
            }
            else {
                label.setVisible(true);
                isVisible = true;
            }
            repaint();
        }
    }

    class Label extends JPanel {

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawString("Just Label", getWidth() / 2, getHeight() / 2);
        }
    }
}
