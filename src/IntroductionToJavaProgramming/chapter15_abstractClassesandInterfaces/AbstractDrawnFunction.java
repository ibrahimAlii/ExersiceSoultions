package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import javax.swing.*;
import java.awt.*;

public abstract class AbstractDrawnFunction extends JPanel {
    //Polygon hold the point
    private Polygon polygon = new Polygon();

    protected AbstractDrawnFunction(){
        drawFunction();
    }

    public abstract double f(int i);

    public void drawFunction() {
        for (int i = -100; i <= 100; i++) {
            polygon.addPoint(i + 200, 200 - (int)f(i));
        }

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawPolygon(polygon);

    }
}
