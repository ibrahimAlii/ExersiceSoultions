package bouncingball;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ball extends JPanel implements ActionListener{

    private int x;
    private int y;
    private int dx = 2;
    private int dy = 2;
    private int radius = 5;
    private int delay = 10;
    private Timer timer = new Timer(delay, this);


    public Ball() {
        timer.start();
    }

    /**
     * To suspend the bal at x&y point
     */
    public void suspend() {
        timer.stop();
    }

    /**
     * To resume the ball movement
     */
    public void resume() {
        timer.start();
    }

    /**
     * Set speed
     */
    public void setDelay(int delay) {
        this.delay = delay;
        timer.setDelay(delay);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.RED);

        // Check boundaries
        if (x < 0 || x > getWidth())
            dx *= -1;
        if (y < 0 || y > getHeight())
            dy *= -1;

        x += dx;
        y += dy;

        g.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        repaint();
    }
}
