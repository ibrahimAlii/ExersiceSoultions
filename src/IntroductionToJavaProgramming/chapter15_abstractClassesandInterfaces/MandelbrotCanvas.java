package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import javax.swing.*;
import java.awt.*;

public class MandelbrotCanvas extends JPanel{

    private final static int COUNT_LIMIT = 80;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (double x = -2.0; x < 2.0; x += 0.01) {
            for (double y = -2.0; y < 2.0; y += 0.01) {
                int c = count(new Complex(x, y));
                if (c == COUNT_LIMIT)
                    g.setColor(Color.BLACK);
                else
                    g.setColor(new Color(
                            c * 77 % 256, c * 58 % 256, c * 159 % 256));

                g.drawRect((int)(x * 100) + 200, (int)(y * 100) + 200, 1, 1);
            }
        }
    }

    private int count(Complex complex) {
        Complex z = new Complex(0, 0);

        for (int i = 0; i < COUNT_LIMIT; i++) {
            z = z.multiply(z).add(complex);
            if (z.abs() > 2) return i;
        }
        return COUNT_LIMIT;
    }


}
