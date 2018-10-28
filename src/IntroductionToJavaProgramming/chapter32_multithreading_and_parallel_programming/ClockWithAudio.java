package IntroductionToJavaProgramming.chapter32_multithreading_and_parallel_programming;


import IntroductionToJavaProgramming.chapter13_graphics.StillClock;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;

import javax.swing.*;
import java.applet.Applet;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ClockWithAudio extends JFrame {

    protected AudioClip[] hoursAudio = new AudioClip[12];
    protected AudioClip[] minutesAudio = new AudioClip[60];

    private AudioClip amAudio ;
    private AudioClip pmAudio ;

    private StillClock clock = new StillClock();

    Timer timer = new Timer(1000, new TimerListener());

    JLabel label = new JLabel("", JLabel.CENTER);

    public ClockWithAudio(){
        amAudio = new AudioClip("C:/Users/Ibrahim/Downloads/evennumberedexercise/audio/am.au");
        pmAudio = new AudioClip("C:\\Users\\Ibrahim\\Downloads\\evennumberedexercise\\audio\\pm.au");

        for (int i = 0; i < 12; i++)
            hoursAudio[i] = new AudioClip("C:\\Users\\Ibrahim\\Downloads\\evennumberedexercise\\audio/hour" + i + ".au");

        for (int i = 0; i < 60; i++)
            minutesAudio[i] = new AudioClip("C:\\Users\\Ibrahim\\Downloads\\evennumberedexercise\\audio/minute" + i + ".au");


        add(clock, BorderLayout.CENTER);
        add(label, BorderLayout.SOUTH);
        timer.start();
    }


    public static void main(String[] args) {
        JFrame frame = new ClockWithAudio();
        frame.setSize(400, 400);
        frame.setVisible(true);

    }


    private class TimerListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            clock.setCurrentTime();
            clock.repaint();
            label.setText(clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSecond());
            if (clock.getSecond() == 0)
                announceTime(clock.getHour(), clock.getMinute());
        }
    }

    private void announceTime(int hour, int minute) {
        // Announce hour
        hoursAudio[hour % 12].play();

        try {
            // Time delay to allow hour's audio to finish
            Thread.sleep(1500);

            // Announce minute
            minutesAudio[minute].play();

            // Time delay to allow minute's audio to dinish
            Thread.sleep(1500);
        } catch (InterruptedException ex) {

        }

        if (hour < 12)
            amAudio.play();
        else pmAudio.play();
    }
}
