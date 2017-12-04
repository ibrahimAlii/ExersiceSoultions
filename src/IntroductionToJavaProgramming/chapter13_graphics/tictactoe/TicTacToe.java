package IntroductionToJavaProgramming.chapter13_graphics.tictactoe;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TicTacToe extends JFrame {

    private String[][] board = initiateArr();
    private JButton[][] xO;
    private String currentPlayer = "X";
    private Logic logic = new Logic();
    private JPanel mainPanel = new JPanel(new GridLayout(3, 3, -1, -1));

    public void startGame() {
        setSize(300, 300);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(300, 300));
        //Initiate the game
        initGame();


        ActionListener actionListener = new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TicTacToe.this.actionPerformed(e);
            }
        };

        addListenerToButtons(actionListener);
    }

    private void addListenerToButtons(ActionListener actionListener) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                xO[i][j].addActionListener(actionListener);
                refresh();
            }
        }
    }

    private void refresh() {
        TicTacToe.this.invalidate();
        TicTacToe.this.validate();
        TicTacToe.this.repaint();
    }

    private void initGame() {
        xO = new JButton[3][3];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                xO[i][j] = new JButton();
                xO[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                mainPanel.add(xO[i][j]);
            }
        }
        add(mainPanel);
    }


    private static String[][] initiateArr() {

        String[][] arr = new String[3][3];
        for (int row = 0; row < arr.length; row++) {
            for (int column = 0; column < arr[row].length; column++) {
                arr[row][column] = " ";
            }
        }
        return arr;
    }

    private void actionPerformed(ActionEvent e) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                JButton clicked = (JButton) e.getSource();
                if (xO[row][col] == clicked) {


                    currentPlayer = (currentPlayer.equals("X") ? "O" : "X");
                    board[row][col] = currentPlayer;
                    xO[row][col].add(new UI(currentPlayer.equals("X") ? UI.O : UI.X));
                    refresh();

                    checkForDrawOrWinners(row, col);


                }
            }
        }

    }

    private void checkForDrawOrWinners(int row, int col) {
        logic.thereIsWinner(board, currentPlayer, row, col);
        logic.thereIsDraw(board, currentPlayer, row, col);
    }


}
