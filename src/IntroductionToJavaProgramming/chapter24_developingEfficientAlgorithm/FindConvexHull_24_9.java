package IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm;

import IntroductionToJavaProgramming.chapter24_developingEfficientAlgorithm.closest_pair_24_7.CompareY;

import java.io.Serializable;
import java.util.*;

/**
 * Find the Convex hull suing "Gift-Wrapping Algorithm"
 */
public class FindConvexHull_24_9 {


    public static void main(String[] args) {

        List<MyPoint> points = new ArrayList<>();

        Scanner input = new Scanner(System.in);

        System.out.print("How many points are in the set? ");

        double pointsCount = input.nextInt();


        System.out.print("\nEnter " + pointsCount + " points: ");
        for (int i = 0; i < pointsCount; i++) {
            points.add(new MyPoint(input.nextDouble(), input.nextDouble()));
        }




        ArrayList<MyPoint> convexHullList = getConvexHull(points);
    }

    private static ArrayList<MyPoint> getConvexHull(List<MyPoint> points) {
        // Get the The rightmost lowest point
        MyPoint rightMostLowestPoint = getRightMostLowestPoint(points);
        MyPoint endPoint = points.get(0);

        System.out.println(rightMostLowestPoint.x + ", " + endPoint.x);

        ArrayList<MyPoint> myConvexHull = new ArrayList<>();

        myConvexHull.add(rightMostLowestPoint);



        return myConvexHull;

    }

    private static MyPoint getRightMostLowestPoint(List<MyPoint> points) {
        List<MyPoint> pointList = new ArrayList<>(points);
        pointList.sort(new CompareX());
        return pointList.get(0);
    }


    static class CompareX implements Comparator<MyPoint> {

        @Override
        public int compare(MyPoint o1, MyPoint o2) {
            if (o1.x > o2.x)
                return 1;
            else if (o1.x == o2.x) {

                if (o1.y > o2.y)
                    return 1;
                else if (o1.y == o2.y)
                    return 0;
                else return -1;
            } else return -1;
        }
    }

    static class MyPoint {

        double x, y;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }
}
