import IntroductionToJavaProgramming.chapter13_graphics.MessagePanel;
import IntroductionToJavaProgramming.chapter13_graphics.StillClock;

import javax.imageio.plugins.jpeg.JPEGHuffmanTable;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.util.Scanner;

/**
 * Created by Ibrahim on 10/08/2017.
 */

public class Main extends JFrame {

    public Main() {
        StillClock clock = new StillClock();

        MessagePanel clockText = new MessagePanel(clock.getHour() + ":" +
                clock.getMinute() + ":" + clock.getSecond());
        clockText.setCentred(true);
        clockText.setForeground(Color.BLUE);
        clockText.setFont(new Font("Courier", Font.BOLD, 16));

        add(clock);
        add(clockText, BorderLayout.SOUTH);
    }


    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Main main = new Main();
        main.setTitle("Clock");
        main.setSize(300, 350);
        main.setLocationRelativeTo(null);
        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        main.setVisible(true);

    }


}

