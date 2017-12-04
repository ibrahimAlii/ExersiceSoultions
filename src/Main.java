import IntroductionToJavaProgramming.chapter13_graphics.*;
import IntroductionToJavaProgramming.chapter13_graphics.tictactoe.TicTacToe;
import IntroductionToJavaProgramming.chapter7_twoDeimensionalArray.TicTacToe_7_9;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;


/**
 * Created by Ibrahim on 10/08/2017.
 */

public class Main extends JFrame  {

    public Main() {
       add(new MultiplicationTable_13_5(9));

    }


    public static void main(String[] args) {
//        Main main = new Main();
//        main.setTitle("Clock");
//        main.setLocationRelativeTo(null);
//        main.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
//        main.setVisible(true);
//        main.setSize(300, 200);
        new TicTacToe().startGame();
        //TicTacToe_7_9.startGame();

    }



}

