package chapter19;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * Address book to Add, Update, And navigate between data.
 */
public class AddressBook extends JFrame implements Serializable {

    private static final String fileName = "Exercise19_08.dat";

    private static RandomAccessFile inout;

    static {
        try {
            inout = new RandomAccessFile(fileName, "rw");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private JPanel controlPanel = new JPanel(new GridLayout(1, 6));
    // Buttons
    private JButton add = new JButton("Add");
    private JButton first = new JButton("First");
    private JButton next = new JButton("Next");
    private JButton previous = new JButton("Previous");
    private JButton last = new JButton("Last");
    private JButton update = new JButton("Update");

    private JPanel inputPanel = new JPanel(new GridLayout(3, 2));
    //Fields
    private JLabel name = new JLabel("Name");
    private static JTextField inName = new JTextField();
    private JLabel street = new JLabel("Street");
    private static JTextField inStreet = new JTextField();
    private JLabel city = new JLabel("City");
    private static JTextField inCity = new JTextField();
    private static String[][] data;


    public AddressBook() throws IOException {

        controlPanel.add(add);
        controlPanel.add(first);
        controlPanel.add(next);
        controlPanel.add(previous);
        controlPanel.add(last);
        controlPanel.add(update);

        add.addActionListener(new ControlListener());
        first.addActionListener(new ControlListener());
        next.addActionListener(new ControlListener());
        previous.addActionListener(new ControlListener());
        last.addActionListener(new ControlListener());
        update.addActionListener(new ControlListener());

        inputPanel.add(name);
        inputPanel.add(inName);
        inputPanel.add(street);
        inputPanel.add(inStreet);
        inputPanel.add(city);
        inputPanel.add(inCity);

        setLayout(new BorderLayout());

        add(controlPanel, BorderLayout.SOUTH);
        add(inputPanel, BorderLayout.CENTER);
    }

    public static void main(String[] smth) throws IOException {


        displayinitialData();

        JFrame frame = new AddressBook();
        frame.setSize(500, 150);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    class ControlListener implements ActionListener {


        ControlListener() throws IOException {
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                handleClickListener(e);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }

        private void handleClickListener(ActionEvent e) throws IOException {
            long position = 0;
            if (e.getSource() == add) {

                inout.writeUTF(inName.getText());
                inout.writeUTF(inStreet.getText());
                inout.writeUTF(inCity.getText());

            } else if (e.getSource() == first) {
                inout.seek(0);
                displayinitialData();
                position = 0;
            } else if (e.getSource() == next) {
                inout.seek(position + (3 * 4));
                displayinitialData();
                position += (3 * 4);
            } else if (e.getSource() == previous) {
                inout.seek(position - (3 * 4));
                displayinitialData();
                position -= (3 * 4);
            } else if (e.getSource() == last) {
                inout.seek(inout.length());
                displayinitialData();
                position = inout.length();
            } else if (e.getSource() == update) {
                inout.writeUTF(inName.getText());
                inout.writeUTF(inStreet.getText());
                inout.writeUTF(inCity.getText());
            }
            System.out.println(position);
        }
    }

    private static void displayinitialData() throws IOException {
        if (inout != null && inout.length() > 0) {
            inName.setText(inout.readUTF());
            inStreet.setText(inout.readUTF());
            inCity.setText(inout.readUTF());
        }
    }
}
