package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class CustomButton extends JButton{

    private String message;
    public CustomButton(String message){

        this.message = message;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        int width = getWidth();
        int height = getHeight();
        g.drawOval((int)(0.1 * width), (int)(0.1 * height),
                (int)(0.8 * width), (int)(0.8 * height));
        g.drawString(message, width /2, height /2);
    }
}
