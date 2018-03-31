package IntroductionToJavaProgramming.chapter18_appletsAndMultimedia;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TicTacToe extends JApplet {

    //Indicate which player has a turn; initially it is the X player
    private char whoseTurn = 'X';

    // Create and initialize cells
    private Cell[][] cells = new Cell[3][3];

    // Create and initialize a status label
    private JLabel jLabelStatus = new JLabel("X's turn to play");

    public TicTacToe() {
        // Panel to hold cells
        JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                panel.add(cells[i][j] = new Cell());
            }
        }

        // Set line border on the cells panel and the statues label
        panel.setBorder(new LineBorder(Color.red, 1));
        jLabelStatus.setBorder(new LineBorder(Color.yellow, 1));

        // Place the panel and the label for the applet
        add(panel, BorderLayout.CENTER);
        add(jLabelStatus, BorderLayout.SOUTH);
    }

    // Determine whether the cells are occupied
    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getToken() == ' ')
                    return false;
            }
        }
        return true;
    }

    /**
     * Determine whether the player with the specified token wins
     */
    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++) {
            if ((cells[i][0].getToken() == token) &&
                    (cells[i][1].getToken() == token) &&
                    (cells[i][2].getToken() == token))
                return true;
        }

        for (int i = 0; i < 3; i++) {
            if ((cells[0][i].getToken() == token) &&
                    (cells[1][i].getToken() == token) &&
                    (cells[2][i].getToken() == token))
                return true;
        }
        if ((cells[0][0].getToken() == token) &&
                (cells[1][1].getToken() == token) &&
                (cells[2][2].getToken() == token)) {
            return true;
        }
        if ((cells[0][2].getToken() == token) &&
                (cells[1][1].getToken() == token) &&
                (cells[2][0].getToken() == token)) {
            return true;
        }

        return false;
    }

    class Cell extends JPanel {

        private char token = ' ';

        public Cell() {
            setBorder(new LineBorder(Color.BLACK, 1));
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    super.mouseClicked(e);
                    if (token == ' ' && whoseTurn != ' '){
                        setToken(whoseTurn);

                        if (isWon(whoseTurn)){
                            jLabelStatus.setText(whoseTurn + " won! The game is over");
                            whoseTurn = ' ';
                        }else if (isFull()){
                            jLabelStatus.setText("Draw! The game is over");
                            whoseTurn = ' ';
                        }else {
                            whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
                            jLabelStatus.setText(whoseTurn + "'s Turn");
                        }
                    }
                }
            });
        }

        public char getToken() {
            return token;
        }

        public void setToken(char token) {
            this.token = token;
            repaint();
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (token == 'X') {
                g.drawLine(10, 10, getWidth() - 10, getHeight() - 10);
                g.drawLine(getWidth() - 10, 10, 10, getHeight() - 10);
            } else if (token == 'O') {
                g.drawOval(10, 10, getWidth() - 10, getHeight() - 10);
            }
        }
    }
}
