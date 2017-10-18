package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

public class AreaOfPentagon {

    public static void getArea(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the side of pentagon");
        double sideOfPentagon = scanner.nextDouble();

        double area = (5 * Math.pow(sideOfPentagon, 2)) / (4 * Math.tan(Math.PI / 5));

        System.out.println(area);


    }

}
