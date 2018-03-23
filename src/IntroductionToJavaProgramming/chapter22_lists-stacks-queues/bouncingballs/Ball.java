package chapter22.bouncingballs;

import javax.swing.*;
import java.awt.*;

public class Ball {

    public int x = 0;
    public int y = 0;
    public int dx = 2;
    public int dy = 2;
    public int radius = 5;
    public Color color =
            new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));


}
