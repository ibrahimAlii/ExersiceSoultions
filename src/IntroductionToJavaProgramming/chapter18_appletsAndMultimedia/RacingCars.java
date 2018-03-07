import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RacingCars extends JApplet implements ActionListener {

    private JTextField jTextField1 = new JTextField("1");
    private JTextField jTextField2 = new JTextField("2");
    private JTextField jTextField3 = new JTextField("3");
    private JTextField jTextField4 = new JTextField("4");

    private RacingCar outerObj = new RacingCar();
    private RacingCar.Car car1 = outerObj.new Car();
    private RacingCar.Car car2 = outerObj.new Car();
    private RacingCar.Car car3 = outerObj.new Car();
    private RacingCar.Car car4 = outerObj.new Car();

    Timer timer = new Timer(100, this);

    public RacingCars() {
        JPanel carPanel = new JPanel(new GridLayout(4, 1));
        JPanel textPanel = new JPanel(new GridLayout(1, 4));

        car1.requestFocus(true);
        carPanel.add(car1);
        carPanel.add(car2);
        carPanel.add(car3);
        carPanel.add(car4);
        car1.setBorder(new LineBorder(Color.BLACK, 1));
        car2.setBorder(new LineBorder(Color.BLACK, 1));
        car3.setBorder(new LineBorder(Color.BLACK, 1));
        car4.setBorder(new LineBorder(Color.BLACK, 1));

        textPanel.add(jTextField1);
        textPanel.add(jTextField2);
        textPanel.add(jTextField3);
        textPanel.add(jTextField4);

        add(carPanel, BorderLayout.CENTER);
        add(textPanel, BorderLayout.NORTH);

        timer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        moveCar(car1, jTextField1);
        moveCar(car2, jTextField2);
        moveCar(car3, jTextField3);
        moveCar(car4, jTextField4);
        repaint();
    }

    private void moveCar(RacingCar.Car car, JTextField textField) {
        if (car.xCoordinate != getWidth())
            car.moveForward();
        else car.xCoordinate = 0;
        car.setSpeed(Integer.parseInt(textField.getText()));
    }
}
