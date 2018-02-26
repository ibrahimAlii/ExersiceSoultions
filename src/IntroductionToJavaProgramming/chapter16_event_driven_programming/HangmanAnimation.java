import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HangmanAnimation extends JFrame {

    private Body body = new Body();
    private Line line = new Line(120, 30, 120, 60);
    private Line lineBody = new Line(120, 30, 120, 60);
    private Circle circle = new Circle(0, 0, 15);
    private Timer timer = new Timer(400, body);

    public HangmanAnimation() {

        add(body);
        body.requestFocus();
        timer.start();

    }

    class Body extends JPanel implements ActionListener {


        public Body() {

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine(30, 30, 30, getHeight() - 30);
            g.drawLine(30, 30, 120, 30);

            g.drawLine((int) line.getStartX(), (int) line.getStartY(),
                    (int) line.getEndX(), (int) line.getEndY());
            g.drawOval((int) line.getEndX() - 15, (int) line.getEndY() + 3, 35, 35);
            circle.setCenterY((int) line.getEndY() + 3);
            circle.setCenterX((int) line.getEndX() - 15);
            g.drawLine((int) line.getEndX() , (int) line.getEndY() + 37, (int) line.getEndX(),
                    getHeight() - 60);

            // set Line body
            lineBody.setStartX((int) line.getEndX());
            lineBody.setStartY((int) line.getEndY() + 37);
            lineBody.setEndX((int) line.getEndX());
            lineBody.setEndY(getHeight() - 60);

            // Draw Hands
            //Right hand
            g.drawLine((int) lineBody.getStartX(), (int) lineBody.getStartY() + 20,
                    (int) lineBody.getStartX() + 30, (int) lineBody.getStartY() + 70);
            // Left hand
            g.drawLine((int) lineBody.getStartX(), (int) lineBody.getStartY() + 20,
                    (int) lineBody.getStartX() - 30, (int) lineBody.getStartY() + 70);

            // Draw Legs
            // Right leg
            g.drawLine((int) lineBody.getEndX(), (int) lineBody.getEndY(),
                    (int) lineBody.getEndX() + 50, (int) lineBody.getEndY() + 70);
            // Left hand
            g.drawLine((int) lineBody.getEndX(), (int) lineBody.getEndY(),
                    (int) lineBody.getEndX() - 50, (int) lineBody.getEndY() + 70);

        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (line.getEndX() < 180)
                line.setEndX(line.getEndX() + 1);
            else line.setEndX(100);

            repaint();
        }
    }
}
