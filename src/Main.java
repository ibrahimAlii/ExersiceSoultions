import IntroductionToJavaProgramming.chapter10_ThinkingInObjects.Rectangle2D;
import IntroductionToJavaProgramming.chapter6_arrays.DecimalToBinary;
import IntroductionToJavaProgramming.chapter7_twoDeimensionalArray.ColumnSorting_7_27;
import IntroductionToJavaProgramming.chapter7_twoDeimensionalArray.LargestBlock_7_35;
import IntroductionToJavaProgramming.chapter7_twoDeimensionalArray.RowSorting_7_26;
import IntroductionToJavaProgramming.chapter8_objectsAndClasses.Rectangle_8_1;
import IntroductionToJavaProgramming.chapter9_strings.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Date;
import java.util.Scanner;


/**
 * Created by Ibrahim on 10/08/2017.
 */


public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create 5 x 2 matrix
        double[][] points = new double[5][2];

        // Prompt the user to enter five points
        System.out.print("\nEnter five points: ");
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j] = input.nextDouble();
            }
        }

        Rectangle2D r1 = Rectangle2D.getRectangle(points);

        System.out.println("The bounding rectangle's center (" + r1.getX() + ", " +
                r1.getY() + "), width " + r1.getWidth() + ", height " + r1.getHigh());

    }



}

