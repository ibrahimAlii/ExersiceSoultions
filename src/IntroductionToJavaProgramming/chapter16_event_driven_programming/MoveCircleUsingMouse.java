import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MoveCircleUsingMouse extends JFrame {

    public MoveCircleUsingMouse(){

        add(new Circle());
    }

    class Circle extends JPanel{

        private int movedTimes = 0;
        private int currentX = this.getWidth() / 2;
        private int currentY = this.getHeight() / 2;
        private javafx.scene.shape.Circle circle = new javafx.scene.shape.Circle(currentX, currentY, 20);

        public Circle(){

            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseDragged(MouseEvent e) {
                    super.mouseDragged(e);
                    if (circle.contains(e.getX(), e.getY())){
                        currentX = e.getX();
                        currentY = e.getY();
                        circle.setCenterX(currentX);
                        circle.setCenterY(currentY);
                        repaint();
                    }

                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawOval(currentX, currentY, 20, 20);
        }
    }
}
