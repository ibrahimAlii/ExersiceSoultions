package bouncingballs;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BallsControl extends JPanel implements ActionListener {

    private JButton suspend = new JButton("Suspend");
    private JButton resume = new JButton("Resume");
    private JButton add = new JButton("+1");
    private JButton remove = new JButton("-1");
    private ArrayList<Ball> balls = new ArrayList<>();
    private JScrollBar scrollBar = new JScrollBar(Adjustable.HORIZONTAL);
    private Timer timer = new Timer(100, this);
    private JPanel ballsPanel = new JPanel();


    public BallsControl() {
        JPanel panel = new JPanel();
        panel.add(suspend);
        panel.add(remove);
        panel.add(add);
        panel.add(resume);

        setLayout(new BorderLayout());

        add(panel, BorderLayout.SOUTH);
        add(ballsPanel, BorderLayout.CENTER);
        add(scrollBar, BorderLayout.NORTH);

        scrollBar.addAdjustmentListener(e -> timer.setDelay(scrollBar.getMaximum() - e.getValue()));

        suspend.addActionListener(e -> timer.stop());
        resume.addActionListener(e -> timer.start());
        add.addActionListener(e -> balls.add(new Ball(ballsPanel.getWidth(), ballsPanel.getHeight())));
        remove.addActionListener(e -> balls.remove(0));

        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (balls.size() > 0) {
            for (Ball ball : balls)
                ballsPanel.add(ball);

            System.out.println(balls.size());
        }
        repaint();
    }
}
