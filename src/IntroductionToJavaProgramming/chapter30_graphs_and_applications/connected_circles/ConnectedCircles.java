package IntroductionToJavaProgramming.chapter30_graphs_and_applications.connected_circles;

import IntroductionToJavaProgramming.chapter30_graphs_and_applications.AbstractGraph;
import IntroductionToJavaProgramming.chapter30_graphs_and_applications.Graph;
import IntroductionToJavaProgramming.chapter30_graphs_and_applications.UnweightedGraph;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class ConnectedCircles extends JFrame {
    // Circles are stored in a list
    private List<Circle> circles = new ArrayList<>();


    public ConnectedCircles() {
        add(new CirclePanel());
    }

    class CirclePanel extends JPanel {
        public CirclePanel() {
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    if (!isInsideACircle(e.getPoint())) {
                        circles.add(new Circle(e.getX(), e.getY()));
                        repaint();
                    }
                }
            });
        }

        private boolean isInsideACircle(Point point) {
            for (Circle c : circles) {
                if (c.contains(point))
                    return true;
            }
            return false;
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (circles.size() == 0)
                return;

            super.paintComponent(g);

            List<AbstractGraph.Edge> edges = new ArrayList<>();
            for (int i = 0; i < circles.size(); i++)
                for (int j = i + 1; j < circles.size(); j++)
                    if (circles.get(i).overlaps(circles.get(j))) {
                        edges.add(new AbstractGraph.Edge(i, j));
                        edges.add(new AbstractGraph.Edge(j, i));
                    }


            Graph<Circle> graph = new UnweightedGraph<>(edges, circles);
            AbstractGraph<Circle>.Tree tree = graph.dfs(0);
            boolean isAllCircleConnected = circles.size() == tree.getNumberOfVerticesFound();

            for (Circle circle : circles) {
                int radius = circle.radius;
                if (isAllCircleConnected) {
                    g.setColor(Color.red);
                    g.fillOval(circle.x - radius, circle.y - radius, 2 * radius, 2 * radius);
                } else {
                    g.drawOval(circle.x - radius, circle.y - radius, 2 * radius, 2 * radius);
                }
            }
        }
    }


    private static class Circle {
        int radius = 20;
        int x, y;

        public Circle(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean contains(Point p) {
            double d = distance(x, y, p.x, p.y);
            return d <= radius;
        }

        public boolean overlaps(Circle circle) {
            return distance(this.x, this.y, circle.x, circle.y) <= radius + circle.radius;
        }

        private double distance(int x1, int y1, int x2, int y2) {
            return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        }
    }
}
