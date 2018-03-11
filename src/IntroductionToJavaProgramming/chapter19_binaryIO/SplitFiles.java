package chapter19;

import java.io.*;
import java.util.Scanner;

public class SplitFiles {

    private static String fileName = "";
    private static long wholeSize = 0;
    private static long numberOfPieces = 0;
    private static long pieceSize = 0;

    public static void main(String[] ay_haga) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the file name: ");
        fileName = scanner.nextLine();

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));

        wholeSize = input.available();
        System.out.println("Write number of pieces: ");
        numberOfPieces = scanner.nextInt();
        pieceSize = (long) Math.ceil(1.0 * wholeSize / numberOfPieces);

        for (int i = 0; i <= numberOfPieces; i++) {
            BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(fileName + "_" + i));

            int count = 0;
            int value;
            while (count++ < pieceSize && (value = input.read()) != -1) {
                output.write(value);
            }
            output.close();
        }
        input.close();
    }
}
