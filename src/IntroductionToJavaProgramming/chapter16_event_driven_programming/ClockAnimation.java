package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import IntroductionToJavaProgramming.chapter13_graphics.StillClock;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClockAnimation extends JFrame {

    private StillClock clock = new StillClock();

    public ClockAnimation(){
        add(clock);

        //Create a timer with delay 1000ms
        Timer timer = new Timer(1000, new TimerListener());
        timer.start();
    }

    private class TimerListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            clock.setCurrentTime();
            clock.repaint();
        }
    }
}
