import IntroductionToJavaProgramming.chapter5_methods.*;
import IntroductionToJavaProgramming.chapter6_arrays.*;

import java.lang.reflect.Array;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Scanner;

import static IntroductionToJavaProgramming.chapter6_arrays.BinarySearch.binarySearch;

/**
 * Created by Ibrahim on 10/08/2017.
 */


public class Main {

    public static void main(String[] args) {

        //System.out.println(ApproximateTheSquareRoot.getApproximatedSquare(4611685984067649600L));
        //GeometryDisplayAngles.getAngles();
        //DisplayCurrentDateAndTime.displayDateAndTime();
        //System.out.println(ConvertMillieSeconds.convertMillis(5500));
        //System.out.println(PalindromicPrime.isPalindromicPrime(141) ? "Both" : "Not true");
        //Emirp.printEmirp();
        //MersennePrime.getTwinPrimes();
        //System.out.print((5^9) - 1);
        //TwinePrime.getTwinPrime();
        //Craps.startGame();
        //CreditCardNumberValidation.checkCreditCard();

        //DisplayCurrentDateAndTime.displayDateAndTime();

        //CurrentDateAndTime.getCurrentDateAndTime();
//        ZellerCongruence.getDayOfMonth();
        //AreaOfPentagon.getArea();

        //System.out.println(AreaOfRegularPolygon.area());
        //System.out.println(FormatInteger.format(34, 0));
//        GeometryPointPosition.getPointPosition();

//        CheckAllTickets.checkAll();
//        DeckOfCards.getDeckOfCards();

//        int[] arr = {5, 6, 8, 9, 11, 120, 11, 50, 1, 3, 15, 121, 33, 16, 17, 18, 19, 20, 21, 31, 36, 37, 55};

        int[] arr1 = {5, 6, 8, 9, 11, 12, 11, 50, 1, 3, 15, 121, 33, 16, 17, 18, 19, 20, 15};
        int[] arr2 = {5, 6, 8, 9, 11, 12, 11, 50, 1, 3, 15, 121, 33, 16, 17, 18};
        InsertionSort.insertionSort(arr1);
        InsertionSort.insertionSort(arr2);


        System.out.println(binarySearch(arr1, 12));
        System.out.println(binarySearch(arr2, 12));

    }



}