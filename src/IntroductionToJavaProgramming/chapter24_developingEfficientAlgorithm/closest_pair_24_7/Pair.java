package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm.closest_pair_24_7;

import java.util.Comparator;

public class Pair {

    private Point p1;
    private Point p2;


    public Pair(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }


    public double getDistance() {
        return Math.sqrt(Math.pow(p1.getX() - p2.getX(), 2) + Math.pow(p1.getY() - p2.getY(), 2));
    }
}
