package IntroductionToJavaProgramming.chapter13_graphics;

import javax.swing.*;
import java.awt.*;

public class MultiplicationTable_13_5 extends JPanel {

    String table = "";
    String tableNumbers;
    public MultiplicationTable_13_5(int tableSize){
        setLayout(new BorderLayout());
        MessagePanel messagePanel = new MessagePanel("Multiplication Table");
        messagePanel.setSize(getWidth() / 2, getHeight() / 2);
        add(messagePanel, BorderLayout.NORTH);


        for (int i = 1; i <= tableSize; i++) {
            tableNumbers += i + " ";
        }
        add(new MessagePanel(tableNumbers), BorderLayout.CENTER);

        JPanel jPanel = new JPanel(new GridLayout(tableSize, tableSize));
        for (int i = 1; i <= tableSize; i++) {
            String row = "";
            for (int j = 1; j <= tableSize; j++) {
                row += (i * j) + " ";
            }
            table += row + "\n";
            jPanel.add(new MessagePanel(row));
        }
        //System.out.println(table);
        //add(new MessagePanel(table), BorderLayout.CENTER);
        add(jPanel, BorderLayout.CENTER);

    }
}
