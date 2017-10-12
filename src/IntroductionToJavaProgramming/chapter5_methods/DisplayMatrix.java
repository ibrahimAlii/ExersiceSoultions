package IntroductionToJavaProgramming.chapter5_methods;

import java.util.Scanner;

/*
Page 241 *5.17
 */
public class DisplayMatrix {

//    public static void printMatrix(int n) {
//        int NUMBERS_PER_LINE = 3;
//        int TOTAL_NUMBERS = 10;
//        int randomMatrix;
//        Scanner input = new Scanner(System.in);
//        n = input.nextInt();
//        for (int i = 0; i < TOTAL_NUMBERS; i++) {
//            randomMatrix = (int) (Math.random() * 10);
//
//            if (i % NUMBERS_PER_LINE == 0)
//                System.out.println();
//
//            if (randomMatrix == n)
//                TOTAL_NUMBERS++;
//            else
//                System.out.print(randomMatrix + " ");
//
//        }
//    }

    public static void printMatrix(int n) {
        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols ++) {
                // Generate and print randomly 0 or 1
                System.out.print((int)(Math.random() * 2));
            }
            // Print newline
            System.out.println();
        }
    }
}
