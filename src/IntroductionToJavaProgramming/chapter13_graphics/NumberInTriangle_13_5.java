package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class NumberInTriangle_13_5 extends JPanel{

    public NumberInTriangle_13_5(int size){

        setLayout(new GridLayout(size, size));
        for (int i = size; i >= 1; i--) {

            for (int j = size; j >= 1; j--) {
                if (j <= i)
                    add(new MessagePanel("" + j));
                else
                    add(new MessagePanel(""));
            }
        }

    }
}
