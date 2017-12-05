package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class PlotSineAndCosFunc extends JPanel {

    public PlotSineAndCosFunc(){

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Polygon pSin = new Polygon();
        Polygon pCos = new Polygon();

        for (int x = -360; x <= 360; x++) {
            pSin.addPoint(x + 200,
                    100 - (int)(50 * Math.sin((x / 100.0) * 2 * Math.PI)));

            pCos.addPoint(x + 200,
                    100 - (int)(50 * Math.cos((x / 100.0) * 2 * Math.PI)));
        }

        g.drawLine(0, 100, 500, 100);
        g.setColor(Color.red);
        g.drawPolyline(pSin.xpoints, pSin.ypoints, pSin.npoints);
        g.setColor(Color.BLUE);
        g.drawPolyline(pCos.xpoints, pCos.ypoints, pCos.npoints);
        g.drawString("-2\u03c0", 100, 100);
        g.drawString("2\u03c0", 300, 100);
        g.drawString("0", 200, 100);

    }
}
