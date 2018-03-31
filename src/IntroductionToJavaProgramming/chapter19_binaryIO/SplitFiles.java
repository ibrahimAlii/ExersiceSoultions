package IntroductionToJavaProgramming.chapter19_binaryIO;

import java.io.*;
import java.util.Scanner;

public class SplitFiles {

    public static void main(String[] ay_haga) throws IOException {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Write the file name: ");
        String fileName = scanner.nextLine();

        BufferedInputStream input = new BufferedInputStream(new FileInputStream(fileName));

        long wholeSize = input.available();
        System.out.println("Write number of pieces: ");
        long numberOfPieces = scanner.nextInt();
        long pieceSize = (long) Math.ceil(1.0 * wholeSize / numberOfPieces);

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