package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class SmileyFace13_13 extends JPanel {

    public SmileyFace13_13(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int xCenter = getWidth() / 2;
        int yCenter = getHeight() / 2;
        int radius = (int)(Math.min(getWidth(), getHeight()) * 0.4);
        int width = getWidth();
        int height = getHeight();

        g.drawOval((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height));
        setLayout(new BorderLayout());

        //Draw left eye
        g.drawOval((int)(0.25 * width), (int)(0.3 * height),
                (int)(0.2 * width), (int)(0.1 * height));

        g.fillOval((int)(0.3 * width), (int)(0.31 * height),
                (int)(0.08 * width), (int)(0.08 * height));

        //Draw right eye
        g.drawOval((int)(width / 1.7), (int)(height /3.3),
                (int)(0.2 * width), (int)(0.1 * height));

        g.fillOval((int)(width / 1.55), (int)(height / 3.15),
                (int)(0.08 * width), (int)(0.08 * height));


        //Draw mouse
        g.drawArc((int)(width * 0.3), (int)(height / 3.6),
                (int)(width * 0.5), (int)(0.5 * height), 220, 90);


        //Draw nose
        Polygon polygon = new Polygon();
        polygon.addPoint(xCenter, yCenter);
        polygon.addPoint(xCenter + 30, yCenter + 30);
        polygon.addPoint(xCenter - 30, yCenter + 30);
        g.drawPolygon(polygon);
    }
}
