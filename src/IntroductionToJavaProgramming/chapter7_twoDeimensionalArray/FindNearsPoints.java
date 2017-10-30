package IntroductionToJavaProgramming.chapter7_twoDeimensionalArray;


import java.util.Scanner;

/*

         |
         |
(-1, 3)  |            (3, 3)
         |  (1, 1) (2. 0.5)
 <_______|_____________________>
         |
         |
         |
         |
         |
         |
 */
public class FindNearsPoints {

    public static void findNearsPoints(){

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of points");
        int numberOfPoints = scanner.nextInt();

        //setting number of rows, number of column is unable to change
        double[][] points = new double[numberOfPoints][2];
        for (int i = 0; i < points.length; i++) {
            points[i][0] = scanner.nextDouble();
            points[i][1] = scanner.nextDouble();
        }

        int point1 = 0, point2 =0;
        double shortestDistance = distance(points[point1][0], points[point1][1],
                points[point2][0], points[point2][1]);

        //get shortest distance
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double distance = distance(points[i][0], points[i][1],
                        points[j][0], points[j][1]);

                if (shortestDistance > distance){

                    point1 = i;
                    point2 = j;
                    shortestDistance = distance;
                }

            }
        }

        System.out.println("The closest two points is" +
        "(" + points[point1][0] + ", " + points[point1][1] +") and ("+
        points[point2][0] + ", " + points[point2][1] + ")");

    }

    public static double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}


