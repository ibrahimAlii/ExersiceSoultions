package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import javax.swing.*;
import java.awt.*;
/**
 * todo
 *
 *
 * {\displaystyle f(z)=z^{n}+c}
 *
 *
 For each pixel (x, y) on the screen, do:
 {
 zx = scaled x coordinate of pixel (scaled to lie in the Mandelbrot X scale (-2.5, 1))
 zy = scaled y coordinate of pixel (scaled to lie in the Mandelbrot Y scale (-1, 1))

 iteration = 0
 max_iteration = 1000

 while (zx*zx + zy*zy < 4  AND  iteration < max_iteration)
 {
 float xtmp = (zx*zx + zy*zy) ^ (n / 2) * cos(n * atan2(zy, zx)) + cx;
 zy = (zx*zx + zy*zy) ^ (n / 2) * sin(n * atan2(zy, zx)) + cy;
 zx=xtmp;

 iteration = iteration + 1
 }
 if (iteration == max_iteration)
 return black;
 else
 return iteration;
 }
 *
 */
public class JuliaSetCanvas extends JPanel{
    private static final int COUNT_LIMIT = 60;


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (double x = -2.0; x < 2.0; x += 0.01) {
            for (double y = -2.0; y < 2.0; y += 0.01){
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
