package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CountCharsWordsAndLinesInFile {

    public static void count() throws IOException{

        //Get file path
        File file = new File("D:\\Android\\AndroidStudioProjects\\javaProjects\\src\\IntroductionToJavaProgramming\\chapter14exception_handling_IO/ArrayIndexOutOfBoundsExceptions.java");

        //Count Characters, words, and Lines
        int[] arr = countContent(file);

        System.out.println("\nFile contain " + arr[0] + " characters\n" +
        arr[1] + " words\n" + arr[2] + " lines");
    }

    private static int[] countContent(File file) throws IOException{
        int[] arr = new int[3];
        /**
         * arr[0] for characters
         * arr[1] for words
         * arr[2] for lines
         */
        Scanner read = new Scanner(file);
        if (file.exists()){
            arr = countLinesAndCharacters(file);

            //Count words
            while (read.hasNext()){
                String word = read.next();
               arr[1]++;
            }
        }
        read.close();
        return arr;
    }

    private static int[] countLinesAndCharacters(File file) throws IOException{
        Scanner read = new Scanner(file);
        int[] linesAndCharacters = new int[3];
        while (read.hasNext()){
            linesAndCharacters[2]++;
            String line = read.nextLine();
            linesAndCharacters[0] += line.length();
        }
        return linesAndCharacters;
    }
}
