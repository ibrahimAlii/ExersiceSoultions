import IntroductionToJavaProgramming.chapter13_graphics.beanmachine.TBeanMachinePane;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


/**
 * Created by Ibrahim on 10/08/2017.
 */

public class Main extends Application implements MouseListener {


    public Main() {



    }
    TBeanMachinePane pane;
    @Override
    public void start(Stage primaryStage) throws Exception {
        pane = new TBeanMachinePane(15, 800, 800);


        System.out.println(pane.getWidth());
        Scene scene = new Scene(pane, pane.getWidth(), pane.getHeight());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Bean Machine");
        primaryStage.show();

    }


    @Override
    public void mouseClicked(MouseEvent e) {
        pane.dropBall();
        System.out.println("clicked");
    }

    @Override
    public void mousePressed(MouseEvent e) {
        pane.dropBall();
        System.out.println("pp");
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

