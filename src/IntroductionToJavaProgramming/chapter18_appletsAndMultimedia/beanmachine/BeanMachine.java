package beanmachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BeanMachine extends JApplet {
    private int numberOfSlots = 9; // Default number of slots
    private int numberOfRows = numberOfSlots - 2;
    private int numberOfBalls = 4; // Total number of balls
    private int numberOfBallsDropped = 0; // Number of the balls dropped
    private JTextField jtfNumberOfSlots = new JTextField(2);
    private JButton jbtStart = new JButton("Start");
    private JButton jbtStop = new JButton("Stop");

    public void setNumberOfBallsDropped(int numberOfBallsDropped) {
        this.numberOfBallsDropped = numberOfBallsDropped;
    }

    private int shift = 0;
    int[] slots = new int[numberOfSlots];
    int moveCount = 0;
    int position = 0;

    private BeanMachinePanel paintPanel = new BeanMachinePanel(shift, numberOfSlots, numberOfRows, slots);
    private Timer timer = new Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            moveCount++;
            if (moveCount <= numberOfRows) {
                if (Math.random() < 0.5)
                    paintPanel.moveRedBallLeft();
                else {
                    paintPanel.moveRedBallRight();
                    position++;
                }
            }
            else {
                slots[position]++;
                paintPanel.startRedBall();
                shift = 0;
                moveCount = 0;
                position = 0;
        /*
        numberOfBallsDropped++;
        if (numberOfBallsDropped >= numberOfBalls) {
          timer.stop();
          paintPanel.hideRedBall();
        }
        */
            }
        }
    });

    public BeanMachine() {
        JPanel panel = new JPanel();
        panel.add(new JLabel("Number of slots:"));
        panel.add(jtfNumberOfSlots);
        panel.add(jbtStart);
        panel.add(jbtStop);

        add(paintPanel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);

        jtfNumberOfSlots.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateNumberOfSlots();
            }
        });

        // Start or restart animation
        jbtStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateNumberOfSlots();
                numberOfBallsDropped = 0;
                shift = 0;
                slots = new int[numberOfSlots];
                moveCount = 0;
                position = 0;
                timer.start();
                paintPanel.startRedBall();
            }
        });

        // Stop animation
        jbtStop.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                timer.stop();
            }
        });
    }

    private void updateNumberOfSlots() {
        numberOfSlots = Integer.parseInt(jtfNumberOfSlots.getText().trim());
        numberOfRows = numberOfSlots - 2;
        slots = new int[numberOfSlots];
        paintPanel.repaint();
    }

}
