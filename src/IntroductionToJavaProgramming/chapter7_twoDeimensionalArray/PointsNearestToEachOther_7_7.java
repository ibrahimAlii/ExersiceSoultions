package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.Scanner;

public class PointsNearestToEachOther_7_7 {

    /*
    Finding nearest 3 points
     */

    public static void getNearestPoints() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points");
        int numberOfPoints = scanner.nextInt();

        //setting number of rows, number of column is unable to change
        double[][] points = new double[numberOfPoints][3];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
            points[i][2] = scanner.nextDouble();
        }

        int point1 = 0, point2 = 1;
        double shortestDistance = distance(points[point1][0], points[point1][1], points[point1][2],
                points[point2][0], points[point2][1], points[point2][2]);

        //get shortest distance
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1], points[i][2],
                        points[j][0], points[j][1], points[j][2]);

                System.out.println(distance);
                if (shortestDistance > distance) {

                    point1 = i;
                    point2 = j;
                    shortestDistance = distance;
                }

            }
        }

        System.out.println("The closest two points is" +
                "(" + points[point1][0] + ", " + points[point1][1] + ") and (" +
                points[point2][0] + ", " + points[point2][1] + ")");

    }

    public static double distance(double x1, double y1, double x2, double y2, double z1, double z2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
    }
}