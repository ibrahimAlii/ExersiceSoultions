import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.AbstractDrawnFunction;
import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1.F2;
import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1.FCos;
import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1.FSin;
import IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces.F_15_1.FTan;

import javax.swing.*;

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
        Main main = new Main();
        main.add(new FCos());
        main.setVisible(true);
        main.setSize(300, 300);

    }


}