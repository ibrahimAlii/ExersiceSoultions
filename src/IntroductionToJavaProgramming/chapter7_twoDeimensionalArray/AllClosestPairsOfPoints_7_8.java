package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AllClosestPairsOfPoints_7_8 {

    public static void getAllClosestPoints(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points");
        int numberOfPoints = scanner.nextInt();

        //setting number of rows, number of column is unable to change
        double[][] points = new double[numberOfPoints][2];
        double[][] closestPoints = new double[numberOfPoints][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        int point1 = 0, point2 = 1;
        double shortestDistance = distance(points[point1][0], points[point1][1],
                points[point2][0], points[point2][1]);

        //get shortest distance
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]);
                //store distance in order to sort it
//                closestPoints[i][j] = distance;

                if (shortestDistance > distance) {

                    point1 = i;
                    point2 = j;
                    shortestDistance = distance;
                }

            }
        }

        //sortArr(closestPoints);

//        for (int row = 0; row < closestPoints.length; row++) {
//            for (int colum = 0; colum < closestPoints[row].length; colum++) {
//                System.out.print("Closest two point : " + closestPoints[row][colum]);
//            }
//            System.out.println();
//        }

//        for (int i = 0; i < points.length; i++) {
//            for (int j = 0; j < points.length; j++) {
//                if (distance(points[i][0], points[i][1],
//                        points[j][0], points[j][1]) == shortestDistance)
//                    System.out.println("The closest two points are " +
//                            "(" + points[i][0] + ", " + points[i][1] + ") and (" +
//                            points[j][0] + ", " + points[j][1] + ")");
//            }
//        }

        List<int[]> nearestPointIndices = new ArrayList<>();
        double shortestDistance2 = Double.MAX_VALUE;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance2 = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]);

                if (shortestDistance2 >= distance2) {
                    if (shortestDistance2 > distance2) {
                        nearestPointIndices.clear();
                        shortestDistance2 = distance2;
                    }
                    nearestPointIndices.add(new int[] { i, j });

                   System.out.println("The closest two points are " +
                           "(" + points[i][0] + ", " + points[i][1] + ") and (" +
                           points[j][0] + ", " + points[j][1] + ")");
                }
            }
        }

        System.out.println("The closest two points is" +
                "(" + points[point1][0] + ", " + points[point1][1] + ") and (" +
                points[point2][0] + ", " + points[point2][1] + ")");

    }

    private static void sortArr(double[][] arr){
        for (int i = 0; i < arr.length; i++) {

            double maxValColumnIndex0 = arr[i][0];
            double maxValColumnIndex1 = arr[i][1];
            int maxIndex = i;

            for (int column = i + 1; column < arr[i].length; column++) {
                if (maxValColumnIndex1 < arr[column][1]){
                    maxValColumnIndex1 = arr[column][1];
                    maxValColumnIndex0 = arr[column][0];
                    maxIndex = column;
                }
                if (i != maxIndex){
                    arr[maxIndex][0] = arr[i][0];
                    arr[maxIndex][1] = arr[i][1];
                    arr[i][0] = maxValColumnIndex0;
                    arr[i][1] = maxValColumnIndex1;

                }
            }
        }

    }
    private static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}