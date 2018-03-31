package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RacingCar extends JFrame {

    private int radius = 5;
    Car car = new Car();
    int time = 100;
    public RacingCar(){

        add(car);

        Timer timer = new Timer(time, new TimerListener());
        timer.start();
    }

    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            if (car.xCoordinate != getWidth())
                car.moveForward();
            else car.xCoordinate = 0;

            repaint();
        }
    }
    public class Car extends JPanel{

        public int xCoordinate = 0;
        public int yCoordinate = 100;

        public void moveForward(){
            xCoordinate++;
        }
        public void setSpeed(int delay){

            time = delay;
            repaint();
        }
        void moveBackWard(){
            xCoordinate--;
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawRect(xCoordinate, yCoordinate - 20, 50, 10);
            int[] x = {xCoordinate + 10, xCoordinate + 20, xCoordinate + 30, xCoordinate + 40};
            int[] y = {yCoordinate - 20, yCoordinate - 30, yCoordinate - 30, yCoordinate - 20};
            g.drawPolygon(x, y, x.length);
            g.drawOval(xCoordinate + 15, yCoordinate - 5, radius * 2, radius);
            g.drawOval(xCoordinate + 35, yCoordinate - 5, radius * 2, radius);

        }
    }
}
