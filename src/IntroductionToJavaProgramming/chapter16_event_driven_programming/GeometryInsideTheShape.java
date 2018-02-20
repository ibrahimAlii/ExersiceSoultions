import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GeometryInsideTheShape extends JFrame {

    public static final int CIRCLE = 1;
    public static final int RECTANGLE = 2;
    public static final int POLYGON = 3;

    private int shapeType = 1;
    private int xMouse;
    private int yMouse;

    private String statue = " ttttt";

    Shape shape = new Shape();


    public GeometryInsideTheShape(int shapeType) {
        this.shapeType = shapeType;

        shape.setFocusable(true);
        add(shape);


    }

    class Shape extends JPanel {

        Circle circle = new Circle(50, 50, 50);
        Rectangle rectangle = new Rectangle(getWidth() / 2, getHeight() / 2, 40, 20);
        public Shape() {
            addMouseMotionListener(new MouseMotionListener() {
                @Override
                public void mouseDragged(MouseEvent e) {

                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    xMouse = e.getX();
                    yMouse = e.getY();

                    if (shapeType == CIRCLE) {
                        if (circle.contains(xMouse, yMouse))
                            statue = "Mouse inside circle";
                        else statue = "Mouse outside circle";
                    } else if (shapeType == RECTANGLE)
                        if (rectangle.contains(xMouse, yMouse))
                            statue = "Mouse is inside rectangle";
                        else statue = "Mouse is outside rectangle";

                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            if (shapeType == CIRCLE)
                g.drawOval(100, 60, 50, 50);
            else if (shapeType == RECTANGLE)
                g.drawRect(getWidth() / 2, getHeight() / 2, 40, 20);
            else if (shapeType == POLYGON)
                g.drawPolygon(new int[5], new int[6], 6);

            g.drawString(statue, xMouse, yMouse);
        }


    }
}
