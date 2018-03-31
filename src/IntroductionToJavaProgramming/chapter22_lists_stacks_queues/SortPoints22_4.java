
import java.util.Arrays;
import java.util.Comparator;

public class SortPoints22_4 {


    public static void main(String[] gg) {

        Point[] points = new Point[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point(Math.random() * 100, Math.random() * 100);
        }

        Arrays.sort(points);
        for (Point p :
                points) {
            System.out.print(p + " ");
        }

        System.out.println();

        Arrays.sort(points, new CompareY());
        for (Point p :
                points) {
            System.out.print(p + " ");
        }
    }

    static class Point implements Comparable<Point> {

        double x;
        double y;

        public Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x < o.x)
                return -1;
            else if (this.x == o.x) {

                if (this.y < o.y)
                    return -1;
                else if (this.y == o.y)
                    return 0;
                else return 1;
            } else return 1;
        }

        @Override
        public String toString() {
            return x + ", " + y;
        }
    }

    static class CompareY implements Comparator<Point> {

        @Override
        public int compare(Point o1, Point o2) {
            if (o1.y < o2.y)
                return -1;
            else if (o1.y == o2.y) {
                if (o1.x < o2.x)
                    return -1;
                else if (o1.x == o2.x)
                    return 0;
                else return 1;
            } else return 1;
        }
    }
}
