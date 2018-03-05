package bouncingball;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;

public class BallControl extends JPanel {

    private Ball ball = new Ball();
    private JScrollBar jScrollBar = new JScrollBar();
    private JButton butResume = new JButton("resume");
    private JButton butSuspend = new JButton("suspend");


    public BallControl(){
        JPanel panel = new JPanel();
        panel.add(butResume);
        panel.add(butSuspend);

        ball.setBorder(new LineBorder(Color.red));
        jScrollBar.setOrientation(JScrollBar.HORIZONTAL);
        ball.setDelay(jScrollBar.getMaximum());
        setLayout(new BorderLayout());
        add(jScrollBar, BorderLayout.NORTH);
        add(ball, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        butResume.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.resume();
            }
        });

        butSuspend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ball.suspend();
            }
        });
        jScrollBar.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                ball.setDelay(jScrollBar.getMaximum() - e.getValue());
            }
        });
    }
}
