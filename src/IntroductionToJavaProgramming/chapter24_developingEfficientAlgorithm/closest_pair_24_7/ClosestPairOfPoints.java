package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm.closest_pair_24_7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPairOfPoints {

    public static final int LIST_SIZE = 100;

    private static List<Point> pointsOrderedOnY = new ArrayList<>();
    private static List<Point> S1 = new ArrayList<>();
    private static List<Point> S2 = new ArrayList<>();
    private static Point midPoint;

    public static void main(String[] args) {


        // Fill the data
        for (int i = 0; i < LIST_SIZE; i++) {
            pointsOrderedOnY.add(new Point(Math.random() * 100, Math.random() * 100));
        }

        // Sort the list
        Collections.sort(pointsOrderedOnY, new CompareY());

        // Obtain mid point
        midPoint = pointsOrderedOnY.get(pointsOrderedOnY.size() / 2);

        // Split into two list
        S1 = pointsOrderedOnY.subList(0, pointsOrderedOnY.size() / 2);
        S2 = pointsOrderedOnY.subList((pointsOrderedOnY.size() / 2) + 1, pointsOrderedOnY.size());

        for (Point point :
                pointsOrderedOnY) {
            if (S1.contains(point) && (midPoint.getX() - point.getX()) <=)

        }

    }


}
