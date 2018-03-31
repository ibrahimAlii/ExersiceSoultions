
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BallPanel extends JPanel {

    int delay = 10;
    ArrayList<Ball> balls = new ArrayList<>();

    Timer timer = new Timer(delay, e -> {
        for (int i = 0; i < balls.size(); i++) {
            Ball ball = balls.get(i);

            for (int j = 0; j < balls.size(); j++) {
                if (j != i) {
                    Ball ball1 = balls.get(j);
                    if (ball.circle.intersects(ball1.x, ball1.y, ball1.radius * 2, ball1.radius * 2)) {
                        ball.radius += ball1.radius;
                        balls.remove(ball1);
                    }
                }
            }
        }
        repaint();

    });

    public BallPanel() {
        timer.start();
    }

    public void add() {
        balls.add(new Ball());
    }

    public void subtract() {
        if (balls.size() > 0)
            balls.remove(balls.size() - 1);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (Ball ball : balls) {
            g.setColor(ball.color);

            if (ball.x < 0 || ball.x > getWidth())
                ball.dx = -ball.dx;

            if (ball.y < 0 || ball.y > getHeight())
                ball.dy = -ball.dy;

            ball.x += ball.dx;
            ball.y += ball.dy;

            ball.circle.setCenterX(ball.x);
            ball.circle.setCenterY(ball.y);

            g.fillOval(ball.x - ball.radius, ball.y - ball.radius,
                    ball.radius * 2, ball.radius * 2);

        }

    }

    public void suspend() {
        timer.stop();
    }

    public void resume() {
        timer.start();
    }

    public void setDelay(int delay) {
        this.delay = delay;
        repaint();
    }
}
