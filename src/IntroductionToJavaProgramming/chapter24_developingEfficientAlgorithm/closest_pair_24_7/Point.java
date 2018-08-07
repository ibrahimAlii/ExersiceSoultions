package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm.closest_pair_24_7;

public class Point implements Comparable<Point> {

    private double x;
    private double y;

    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public int compareTo(Point o) {
        if (this.x < o.x)
            return -1;
        else if (x == o.x) {

            if (y < o.y)
                return -1;
            else if (y == o.y)
                return 0;
            else return 1;

        } else return 1;
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
