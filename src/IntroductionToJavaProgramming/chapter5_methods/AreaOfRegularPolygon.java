package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

public class AreaOfRegularPolygon {

    public static double area(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of sides");
        double numberOfSide = scanner.nextDouble();
        System.out.println("Enter the side");
        double sideOfPolygon = scanner.nextDouble();

        double area = (numberOfSide * Math.pow(sideOfPolygon, 2)) / (4 * Math.tan(Math.PI / numberOfSide));

        System.out.println(area);
        return area;
    }
}
