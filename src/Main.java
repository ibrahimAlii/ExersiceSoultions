import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.*;
import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1.*;
import IntroductionToJavaProgramming.chapter16_event_driven_programming.*;

import javax.swing.*;
import java.awt.*;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimeZone;

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



    public static int determine(int a, int b){
        int num1, num2 , result = 0;
        if (a > b) {
            num1 = a;
            num2 = b;
        }else {
            num1 = b;
            num2 = a;
        }

        for (int i = 1; i <= num2; i++) {
            if ((num1 * i) % num2 == 0)
                result = i * num1;

            System.out.println(result);
        }
        return result;
    }
    public static void main(String[] args) {
//        JFrame main = new DisplayRunningFan();
//        //main.add(new JuliaSetCanvas());
//        main.setSize(500, 500);
//        main.setLocationRelativeTo(null);
//        main.setVisible(true);
//        main.setDefaultCloseOperation(EXIT_ON_CLOSE);



    }


}