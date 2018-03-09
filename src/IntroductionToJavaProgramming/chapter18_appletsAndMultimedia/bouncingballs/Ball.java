package bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JPanel implements ActionListener {

    private int x;
    private int y;
    private int dx = 2;
    private int dy = 2;
    private int radius = 5;
    private int delay = 10;
    private Timer timer = new Timer(delay, this);
    private int width;
    private int height;

    public Ball(int width, int height) {
        this.width = width;
        this.height = height;
       // timer.start();
    }



    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (x < 0 || x > width)
            dx *= -1;
        if (y < 0 || y > height)
            dy *= -1;

        x += dx;
        y += dy;
        g.drawOval(x, y, radius * 2, radius * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
