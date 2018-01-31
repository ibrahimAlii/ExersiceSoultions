package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseListener extends JFrame {

    public MouseListener(){

        add(new MouseAction());
    }

    private class MouseAction extends JPanel {


        private MouseAction(){

            addMouseListener(new MouseAdapter() {
                @Override
                public void mousePressed(MouseEvent e) {
                    super.mousePressed(e);
                    setBackground(Color.BLACK);
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    super.mouseReleased(e);
                    setBackground(Color.WHITE);
                }
            });
        }

    }
}
