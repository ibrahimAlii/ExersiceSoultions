package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SimpleCalculator extends JFrame {

    private final JButton divide;
    private final JButton multiply;
    private final JButton subtract;
    private final JButton add;
    private final JTextField result;
    private final JTextField number2;
    private final JTextField number1;

    public SimpleCalculator(){

        JPanel input = new JPanel(new GridLayout(1, 3));
        JPanel control = new JPanel(new GridLayout(1, 4));

        number1 = new JTextField("Number 1");
        number2 = new JTextField("Number 2");
        result = new JTextField("Result");
        input.add(number1);
        input.add(number2);
        input.add(result);

        add = new JButton("Add");
        subtract = new JButton("Subtract");
        multiply = new JButton("Multiply");
        divide = new JButton("Divide");
        control.add(add);
        control.add(subtract);
        control.add(multiply);
        control.add(divide);

        // Add Listener
        add.addActionListener(new CalculateListener());
        multiply.addActionListener(new CalculateListener());
        divide.addActionListener(new CalculateListener());
        subtract.addActionListener(new CalculateListener());
        add(input, BorderLayout.CENTER);
        add(control, BorderLayout.SOUTH);

    }

    class CalculateListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == add)
                result.setText(String.valueOf(Integer.valueOf(number1.getText()) + Integer.valueOf(number2.getText())));
            else if (e.getSource() == subtract)
                result.setText(String.valueOf(Integer.valueOf(number1.getText()) - Integer.valueOf(number2.getText())));
            else if (e.getSource() == multiply)
                result.setText(String.valueOf(Integer.valueOf(number1.getText()) * Integer.valueOf(number2.getText())));
            else if (e.getSource() == divide)
                result.setText(String.valueOf(Integer.valueOf(number1.getText()) / Integer.valueOf(number2.getText())));
        }
    }
}
