import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class HitBalloonsGame extends JFrame{

    ///
    Game game = new Game();
    public HitBalloonsGame(){

        game.requestFocus();
        add(game);
    }

    class Game extends JPanel{

        private int shootX;
        private int shootY;

        public Game(){

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
                    repaint();

                }
            });
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.drawLine((int)(shootX * 0.9), getHeight() - 20, getWidth() / 2, getHeight() - 2);
            g.fillOval((int)(shootX * 0.9), getHeight() - 35, 10, 10);

            int currentX = (int)(shootX * 0.9);
            g.drawOval(currentX + getWidth() - 10, getHeight() / 2, 10, 10);

        }
    }
}
