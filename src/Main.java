
import IntroductionToJavaProgramming.chapter14exception_handling_IO.*;
import IntroductionToJavaProgramming.chapter14exception_handling_IO.NumberFormatException;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;


/**
 * Created by Ibrahim on 10/08/2017.
 */
abstract class Main {


    public Main() {


    }
//    TBeanMachinePane pane;
//    @Override
//    public void start(Stage primaryStage) throws Exception {
//        pane = new TBeanMachinePane(45, 800, 800, 5, 1);
//
//
//        for (int i = 0; i < 400; i++) {
//            pane.dropBall();
//        }
//        System.out.println(pane.getWidth());
//        Scene scene = new Scene(pane, pane.getWidth(), pane.getHeight());
//        primaryStage.setScene(scene);
//        primaryStage.setTitle("Bean Machine");
//        primaryStage.show();
//
//    }



    static int getTotalX(int[] a, int[] b) {
        // Complete this function
        int totalCount = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                if (b[j] % a[i] == 0)
                    totalCount++;
            }
        }
        return totalCount;
    }

    public static void main(String[] args) throws IOException {


        Scanner input = new Scanner(System.in);
        Hangman.launchGame();



    }


    private static void method() {
        try {
            int i = 1 / 0;
            System.out.println("i is " + i);
        }catch (RuntimeException ex){
            System.out.println("RuntimeException in method");
            throw ex;
        }catch (Exception ex){
            System.out.println("Exception in method");
            throw ex;
        }
    }

    private static int sum(int[] ints) {

        int result = 0;
        for (int i = 0; i < ints.length; i++) {
            result += ints[i];
        }
        return result;
    }
}


//    static int[] balancedOrNot(String[] expressions, int[] maxReplacements) {
//
//        int[] balancedArr = new int[expressions.length];
//        for (int i = 0; i < expressions.length; i++) {
//            if (requiredCheck(expressions[i])) {
//
//                if (ableToBeBalanced(expressions[i], maxReplacements[i])) {
//                    balancedArr[i] = 1;
//                } else {
//                    balancedArr[i] = 0;
//                }
//
//            } else {
//                //It's already balanced
//                balancedArr[i] = 1;
//            }
//        }
//
//        return balancedArr;
//    }
//    //<<<><><>
//    private static boolean ableToBeBalanced(String expression, int maxReplacement) {
//
//        int differentPair = differentCount(expression);
//
//
//        return maxReplacement >= differentPair;
//    }
//
//    private static int differentCount(String expressions) {
//        int differenPairCount = 0;
//        int index = 1, index2 = 2;
//        for (int i = 0; i < expressions.length() - 1; i++) {
//
//            if (i == 0) {
//                if (Character.toString(expressions.charAt(i)).equals("<")&& Character.toString(expressions.charAt(i + 1)).equals(">"))
//                    System.out.println("");
//                //differenPairCount = false;
//
//            } else if (Character.toString(expressions.charAt(i + index)).equals("<")&& Character.toString(expressions.charAt(i + index2)).equals(">")) {
//                //differenPairCount = false;
//                index++;
//                index2++;
//            } else {
//                differenPairCount++;
//            }
//
//        }
//        return differenPairCount;
//
//    }
//
//    private static boolean requiredCheck(String expressions) {
//        /** This method to check if string is already balanced e.g "<><><><><><><><>"*/
//        boolean isRequired = true;
//        int index = 1, index2 = 2;
//        for (int i = 0; i < expressions.length() / 2; i++) {
//
//            if (i == 0) {
//                if (Character.toString(expressions.charAt(i)).equals("<")&& Character.toString(expressions.charAt(i + 1)).equals(">"))
//                    isRequired = false;
//
//            } else if (Character.toString(expressions.charAt(i + index)).equals("<")&& Character.toString(expressions.charAt(i + index2)).equals(">")) {
//                index++;
//                index2++;
//                isRequired = false;
//            } else {
//                return true;
//            }
//
//        }
//        return isRequired;
//    }
