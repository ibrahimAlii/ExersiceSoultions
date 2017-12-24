package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RemoveTextFromFile {

    private static Scanner in;
    private static PrintWriter writer;
    private static String newWord = "";

    public static void removeText() throws IOException {

        File file = new File("path.../test.txt");

        in = new Scanner(file);
        while (in.hasNext()) {

            if (!in.next().equals("Ibrahim")){
                newWord += " " + in.next();
            }
        }
        in.close();
        writer = new PrintWriter(file);
        writer.print(newWord);
        writer.close();
    }
}
