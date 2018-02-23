import javafx.scene.shape.Line;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Line2D;
import java.util.ArrayList;

public class ClosestPairOfPoints extends JFrame {


    private ArrayList<Point> circles = new ArrayList();
    private ArrayList<Line> lines = new ArrayList<>();

    public ClosestPairOfPoints() {

        add(new Pairs());
    }

    class Pairs extends JPanel {

        private int cX;
        private int cY;

        public Pairs() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    cX = e.getX();
                    cY = e.getY();
                    circles.add(new Point(e.getX(), e.getY()));
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (int i = 0; i < circles.size(); i++) {
                g.drawOval((int) circles.get(i).getX(), (int) circles.get(i).getY(),
                        5, 5);

            }
            if (circles.size() > 1) {
                for (int i = 0; i < circles.size() - 1; i++) {
//                    g.drawLine((int) circles.get(i).getX(), (int) circles.get(i).getY(),
//                            (int) circles.get(i + 1).getX(), (int) circles.get(i + 1).getY());
                    lines.add(new Line(circles.get(i).getX(), circles.get(i).getY(),
                            circles.get(i).getX(), circles.get(i).getY()));
                }
            }

            if (circles.size() > 2) {
                // Determine shortest path

                double length ;

                for (int i = 0; i < circles.size() - 1; i++) {
                    length = Math.sqrt(((circles.get(i + 1).getX() - circles.get(i).getX()) *
                            (circles.get(i + 1).getX() - circles.get(i).getX())) +
                            ((circles.get(i + 1).getY() - circles.get(i).getY()) *
                                    (circles.get(i + 1).getY() - circles.get(i).getY())));

                    for (int j = 0; j < circles.size() - 1; j++) {


                        double newLength = Math.sqrt(((circles.get(j + 1).getX() - circles.get(j).getX()) *
                                (circles.get(j + 1).getX() - circles.get(j).getX())) +
                                ((circles.get(j + 1).getY() - circles.get(j).getY()) *
                                        (circles.get(j + 1).getY() - circles.get(j).getY())));

                        if (newLength < length) {
                            length = newLength;
                            new Pairs();
                            g.fillOval((int) circles.get(j).getX(), (int) circles.get(j).getY(), 5, 5);
                            g.fillOval((int) circles.get(j + 1).getX(), (int) circles.get(j + 1).getY(), 5, 5);
                        }
                        System.out.println(length);
                    }
                }
            }
        }
    }
}
