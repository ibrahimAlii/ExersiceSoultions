package IntroductionToJavaProgramming.chapter5_methods;


import java.util.Scanner;

/*
Calculate distance between two points (latitude & longitude)
 */
public class GeometryCircleDistance {

    public static void calculateDistance(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter point 1 (latitude and longitude) in degrees:");
        double latitude1 = scanner.nextDouble();
        double longitude1 = scanner.nextDouble();
        System.out.println("Enter point 2 (latitude and longitude) in degrees:");
        double latitude2 = scanner.nextDouble();
        double longitude2 = scanner.nextDouble();
        double radius = 6371.01; // earth radius
        System.out.println("The distance between two points is " +
                calculateDistance(Math.toRadians(latitude1), Math.toRadians(longitude1),
                Math.toRadians(latitude2), Math.toRadians(longitude2), radius) + " km");
    }

    private static double calculateDistance(double lat1,
                                            double long1,
                                            double lat2,
                                            double long2,
                                            double radius)
    {


        return radius * Math.acos(Math.sin(lat1) * Math.sin(lat2) +
                Math.cos(lat1) * Math.cos(lat2) * Math.cos(long1 - long2));

    }

}
