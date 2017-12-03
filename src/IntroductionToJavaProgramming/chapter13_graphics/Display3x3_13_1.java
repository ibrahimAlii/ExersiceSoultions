package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class Display3x3_13_1 extends JFrame {

    public Display3x3_13_1(){
        setLayout(new GridLayout(3, 3, 0, 0));


        for (int i = 0; i < 3 * 3; i++) {

            add(new FigurePanel().drawCrossLine(Color.BLUE, 50, 50, 50, 50));
        }
    }
}
