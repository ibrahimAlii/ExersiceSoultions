package IntroductionToJavaProgramming.chapter13_graphics.tictactoe;

import javax.swing.*;
import java.awt.*;

public class UI extends JPanel {

    public static final int X = 1;
    public static final int O = 2;
    private int type = 0;

    public UI(int type) {
        this.type = type;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        switch (type) {

            //Draw O "Ovale"
            case O:
                g.drawOval((int) (0.1 * width), (int) (0.1 * height),
                        (int) (0.8 * width), (int) (0.8 * height));
                break;
            //Draw X "Cross lines"
            case X:
                g.drawLine(10, 10, width - 10, height - 10);
                g.drawLine(width - 10, 10, 10, height - 10);
                break;
        }
    }
}
