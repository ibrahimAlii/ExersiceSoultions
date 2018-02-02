import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.*;
import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1.*;
import IntroductionToJavaProgramming.chapter16_event_driven_programming.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Ibrahim on 10/08/2017.
 */



 public class Main extends JFrame {


    public Main() {


    }

//    TBeanMachinePane pane;
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        pane = new TBeanMachinePane(45, 800, 800, 5, 1);
//
//
//        for (int i = 0; i < 400; i++) {
//            pane.dropBall();
//        }
//        System.out.println(pane.getWidth());
//        Scene scene = new Scene(pane, pane.getWidth(), pane.getHeight());
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Bean Machine");
//        primaryStage.show();
//
//    }



    public static void main(String[] args) {
        JFrame main = new DisplayRunningFan();
        //main.add(new JuliaSetCanvas());
        main.setSize(500, 500);
        main.setLocationRelativeTo(null);
        main.setVisible(true);
        main.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }


}