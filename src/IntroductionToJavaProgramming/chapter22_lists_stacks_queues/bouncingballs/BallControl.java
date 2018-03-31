
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class BallControl extends JPanel {

    private BallPanel ballPanel = new BallPanel();
    private JScrollBar jScrollDelay = new JScrollBar();

    public BallControl() {
        JPanel panel = new JPanel();
        JButton suspend = new JButton("Suspend");
        panel.add(suspend);
        JButton resume = new JButton("Resume");
        panel.add(resume);
        JButton add = new JButton("+1");
        panel.add(add);
        JButton subtract = new JButton("-1");
        panel.add(subtract);

        ballPanel.setBorder(new LineBorder(Color.red));
        jScrollDelay.setOrientation(Adjustable.HORIZONTAL);
        ballPanel.setDelay(jScrollDelay.getMaximum());
        setLayout(new BorderLayout());
        add(jScrollDelay, BorderLayout.NORTH);
        add(ballPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        suspend.addActionListener(e -> ballPanel.suspend());
        resume.addActionListener(e -> ballPanel.resume());
        add.addActionListener(e -> ballPanel.add());
        subtract.addActionListener(e -> ballPanel.subtract());
        jScrollDelay.addAdjustmentListener(e -> ballPanel.setDelay(jScrollDelay.getMaximum() - e.getValue()));

    }
}
