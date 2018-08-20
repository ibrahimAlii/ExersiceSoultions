package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm.closest_pair_24_7;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestPairOfPoints {

    public static final int LIST_SIZE = 10000000;

    private static List<Point> pointsOrderedOnY = new ArrayList<>();
    private static List<Point> S1 = new ArrayList<>();
    private static List<Point> S2 = new ArrayList<>();
    private static Point midPoint;

    private static int d1, d2, d3;

    public static void main(String[] args) {


        // Fill the data
        long start = System.currentTimeMillis();
        for (int i = 0; i < LIST_SIZE; i++) {
            pointsOrderedOnY.add(new Point(Math.random() * 100, Math.random() * 100));
        }
        System.out.println(System.currentTimeMillis() - start);

        long startTime = System.currentTimeMillis();
        // Sort the list
        Collections.sort(pointsOrderedOnY, new CompareY());

        System.out.println(System.currentTimeMillis() - startTime);
        // Obtain mid point
        midPoint = pointsOrderedOnY.get(pointsOrderedOnY.size() / 2);

        // Split into two list
        S1 = pointsOrderedOnY.subList(0, pointsOrderedOnY.size() / 2);
        S2 = pointsOrderedOnY.subList((pointsOrderedOnY.size() / 2) + 1, pointsOrderedOnY.size());

        // TODO: 19/08/2018 complete this
        for (Point point : pointsOrderedOnY) {
//            if (S1.contains(point) && (midPoint.getX() - point.getX()) <= )

        }

    }


}
