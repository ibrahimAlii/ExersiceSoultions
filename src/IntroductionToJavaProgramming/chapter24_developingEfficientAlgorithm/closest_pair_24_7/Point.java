package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm.closest_pair_24_7;

public class Point{

    private double x;
    private double y;

    public Point(){

    }

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }



    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return x + ", " + y;
    }
}
