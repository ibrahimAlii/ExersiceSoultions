package IntroductionToJavaProgramming.chapter22_lists_stacks_queues.bouncingballs;

import javafx.scene.shape.Circle;

import java.awt.*;

public class Ball {

    public int x = 0;
    public int y = 0;
    public int dx = 2;
    public int dy = 2;
    public int radius = 5;
    Circle circle = new Circle(x, y, radius);
    public Color color =
            new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));


}
