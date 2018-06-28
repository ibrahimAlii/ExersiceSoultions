package IntroductionToJavaProgramming.chapter16_event_driven_programming;


import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class SelfAvoidingRandomWalk extends JFrame {

    Timer timer = new Timer(800, new RandomWalk());
    RandomWalk randomWalk = new RandomWalk();
    private double size = 20;
    private double squareCount = 16;
    private double w = size * squareCount;
    private double h = w;
    private javafx.geometry.Point2D centerP = new javafx.geometry.Point2D(w / 2, h / 2);
    private javafx.geometry.Point2D currentP = centerP;
    private boolean hasHitBorder;

    // All valid points
    ArrayList<javafx.geometry.Point2D> points = new ArrayList<>();

    public SelfAvoidingRandomWalk() {

        add(randomWalk);
        randomWalk.requestFocus();
        randomWalk.requestFocus(true);
        timer.start();
    }

    class RandomWalk extends JPanel implements ActionListener {


        private Line line = new Line(w, h, w, h);

        public RandomWalk() {

            setPreferredSize(new Dimension((int) w, (int) h));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine((int) line.getStartX(), (int) line.getStartY(),
                    (int) line.getEndX(), (int) line.getEndY());
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            while (nextPath() && !hasHitBorder) {
                System.out.println("dddd");
                repaint();
            }

        }

        private boolean nextPath() {
            // get possible paths
            javafx.geometry.Point2D[] possiblePs = new javafx.geometry.Point2D[4];
            possiblePs[0] = new javafx.geometry.Point2D(currentP.getX(), currentP.getY() - size); // up
            possiblePs[1] = new javafx.geometry.Point2D(currentP.getX(), currentP.getY() + size); // down
            possiblePs[2] = new javafx.geometry.Point2D(currentP.getX() - size, currentP.getY()); // left
            possiblePs[3] = new javafx.geometry.Point2D(currentP.getX() + size, currentP.getY()); // right

            boolean hasMoved = false;
            boolean[] isUsed = new boolean[possiblePs.length];

            for (int i = 0; i < 4; ) {
                int ranIndex = (int) (Math.random() * 4);

                if (!isUsed[ranIndex]) {
                    isUsed[ranIndex] = true;
                    i++;
                    javafx.geometry.Point2D p = possiblePs[ranIndex];
                    if (randomWalk.getBounds().contains(/*points,*/ p.getX(), p.getY())) {

                        // draw path
                        line = new Line(
                                currentP.getX(), currentP.getY(),
                                p.getX(), p.getY());
                        currentP = p; // update current Point
                        //getChildren().add(line);


                        // remove point from point tracker
                        //PaneCollection.removePoint(points, p.getX(), p.getY());

                        // make the new point the current point
                        // update hasMoved
                        hasMoved = true;
                        checkBorder(currentP);

                        break; // break out of loop early
                    }

                }
            }

            return hasMoved; // return moved status
        }

        private void checkBorder(javafx.geometry.Point2D p) {
            double x = p.getX();
            double y = p.getY();

            if (x <= 0 || x >= w) hasHitBorder = true;
            if (y <= 0 || y >= h) hasHitBorder = true;
        }
    }

}
