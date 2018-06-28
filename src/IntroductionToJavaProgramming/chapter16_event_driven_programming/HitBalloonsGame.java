package IntroductionToJavaProgramming.chapter16_event_driven_programming;

import javafx.scene.shape.Circle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class HitBalloonsGame extends JFrame {

    private Game game = new Game();
    private Circle balloon;
    private Circle shoot;
    Timer timer;
    // TODO: 24/02/2018 complete this game

    public HitBalloonsGame() {

        timer = new Timer(500, new Game());
        game.requestFocus();
        add(game);
    }

    class Game extends JPanel implements ActionListener {

        private int shootX;
        private int shootY;
        private boolean balloonExist = false;
        private boolean isFired = false;

        private int balloonX;
        private int balloonY;

        private int mX;
        private int mY;

        public Game() {

            //
            addMouseMotionListener(new MouseMotionAdapter() {
                @Override
                public void mouseMoved(MouseEvent e) {
                    super.mouseMoved(e);
                    shootX = e.getX();
                    shootY = e.getY();
                    repaint();
                }
            });

            //
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    isFired = true;
                    timer.start();
                    repaint();
                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine((int) (shootX * 0.9), getHeight() - 20, getWidth() / 2, getHeight() - 2);
            if (!isFired) {
                g.fillOval((int) (shootX * 0.9), getHeight() - 35, 10, 10);
                shoot = new Circle(shootX * .09, getHeight() - 35, 5);
            }

            if (!balloonExist) {
                balloon = new Circle(new Random().nextDouble() * (getWidth() - 10),
                        new Random().nextDouble() * (getHeight() - 10), 10);
                balloonX = (int) balloon.getCenterX();
                balloonY = (int) balloon.getCenterY();
            }


            g.drawOval(balloonX, balloonY, 20, 20);

            if (isFired) {
                g.fillOval(mX, mY, 10, 10);
            }
            balloonExist = true;
        }

        @Override
        public void actionPerformed(ActionEvent e) {

            if (shoot.getCenterY() < game.getHeight() && shoot.getCenterY() > 0/*&& shoot.getCenterX() < getWidth()*/) {
                // shoot.setCenterX(shoot.getCenterX() + 1);
                mY = (int) (shoot.getCenterY() - 1);
                shoot.setCenterY(mY);
                mX = (int) (shoot.getCenterX() - 1);
                shoot.setCenterX(mX);
                System.out.println(shoot.getCenterY());
                repaint();
            }
        }
    }
}
