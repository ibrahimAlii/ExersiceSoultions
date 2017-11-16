package IntroductionToJavaProgramming.chapter5_methods;

import java.awt.*;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class GeometryDisplayAngles {
    private static double angleCy;
    private static double angleCx;
    private static double angleBy;
    private static double angleBx;
    private static double angleAy;
    private static double angleAx;


    public static void getAngles() {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter three points:");
        System.out.println("Enter x1:");
        angleAx = scanner.nextDouble();
        System.out.println("Enter y1:");
        angleAy = scanner.nextDouble();
        System.out.println("Enter x2:");
        angleBx = scanner.nextDouble();
        System.out.println("Enter y2:");
        angleBy = scanner.nextDouble();
        System.out.println("Enter x3:");
        angleCx = scanner.nextDouble();
        System.out.println("Enter y3:");
        angleCy = scanner.nextDouble();


        System.out.println(decimalFormat.format(Math.toDegrees(getAngleA(angleBx, angleBy, angleCx, angleCy)))
                + " " + decimalFormat.format(Math.toDegrees(getAngleB(angleAx, angleAy, angleCx, angleCy)))
                + " " + decimalFormat.format(Math.toDegrees(getAngleC(angleAx, angleAy, angleBx, angleBy))));

    }

    public static double getAngleA(double ruleX, double ruleY, double ruleX1, double ruleY1){

        return Math.acos((Math.atan2(angleAx, angleAy) * Math.atan2(angleAx, angleAy) -
                Math.atan2(angleBx, angleBy) * Math.atan2(angleBx, angleBy) -
                Math.atan2(angleCx, angleCy) * Math.atan2(angleCx, angleCy)) /
                        ( -2 * Math.atan2(ruleX, ruleY) * Math.atan2(ruleX1, ruleY1)));
    }
    public static double getAngleB(double ruleX, double ruleY, double ruleX1, double ruleY1){

        return Math.acos((Math.atan2(angleBx, angleBy) * Math.atan2(angleBx, angleBy) -
                Math.atan2(angleAx, angleAy) * Math.atan2(angleAx, angleAy) -
                Math.atan2(angleCx, angleCy) * Math.atan2(angleCx, angleCy)) /
                ( -2 * Math.atan2(ruleX, ruleY) * Math.atan2(ruleX1, ruleY1)));
    }
    public static double getAngleC(double ruleX, double ruleY, double ruleX1, double ruleY1){

        return Math.acos((Math.atan2(angleCx, angleCy) * Math.atan2(angleCx, angleCy) -
                Math.atan2(angleBx, angleBy) * Math.atan2(angleBx, angleBy) -
                Math.atan2(angleAx, angleAy) * Math.atan2(angleAx, angleAy)) /
                ( -2 * Math.atan2(ruleX, ruleY) * Math.atan2(ruleX1, ruleY1)));
    }
}
