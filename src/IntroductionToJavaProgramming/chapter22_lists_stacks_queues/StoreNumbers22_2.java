
import javax.swing.*;
import java.awt.*;
import java.util.Collections;
import java.util.LinkedList;

public class StoreNumbers22_2 extends JFrame {

    JButton sort = new JButton("Sort");
    JButton shuffle = new JButton("Shuffle");
    JButton reverse = new JButton("Reverse");
    JTextArea textArea = new JTextArea();
    JLabel label = new JLabel("Enter a number: ");
    JTextField textField = new JTextField(null);

    private LinkedList<Integer> list = new LinkedList<>();

    public StoreNumbers22_2() {

        JPanel panelControl = new JPanel();
        JPanel input = new JPanel();
        panelControl.add(sort);
        panelControl.add(shuffle);
        panelControl.add(reverse);

        input.add(label);
        input.add(textField);

        setLayout(new BorderLayout());

        add(panelControl, BorderLayout.SOUTH);
        add(input, BorderLayout.NORTH);
        add(textArea, BorderLayout.CENTER);

        sort.addActionListener(e -> {
            Collections.sort(list);
            filter(list);
        });
        reverse.addActionListener(e -> {
            Collections.reverse(list);
            filter(list);
        });
        shuffle.addActionListener(e -> {
            Collections.shuffle(list);
            filter(list);
        });

        textField.addActionListener(e -> {
            list.add(Integer.valueOf(textField.getText()));
            filter(list);
        });

    }

    private void filter(LinkedList<Integer> list) {
        textArea.setText(list.toString());
        repaint();
    }

    public static void main(String[] gg) {

        JFrame frame = new StoreNumbers22_2();
        frame.setVisible(true);
        frame.setSize(500, 250);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }


}
