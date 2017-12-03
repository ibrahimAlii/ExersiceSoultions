package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class MultiplicationTable_13_5 extends JPanel {

    String table = "";
    public MultiplicationTable_13_5(int tableSize){
        MessagePanel messagePanel = new MessagePanel("Multiplication Table");
        messagePanel.setSize(getWidth() / 2, getHeight() / 2);
        //add(messagePanel);

        for (int i = 1; i <= tableSize; i++) {
            String row = "";
            for (int j = 1; j <= tableSize; j++) {
                row += (i * j) + " ";
            }
            table += row + "\n";
        }
        System.out.println(table);
        add(new MessagePanel(table));
    }
}
