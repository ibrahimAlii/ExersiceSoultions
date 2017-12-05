package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class PlotSquareFunc_13_11 extends JPanel{

    public PlotSquareFunc_13_11(){

        setLayout(new BorderLayout());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        double scaleFactor = 0.1;
        Polygon p = new Polygon();

        for (int x = -100; x <= 100; x++) {
            p.addPoint(x + 200, 200 - (int)(scaleFactor * x * x));
        }

        g.drawPolygon(p.xpoints, p.ypoints, p.npoints);

    }
}
