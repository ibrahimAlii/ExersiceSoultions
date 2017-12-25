package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class CountCharsWordsAndLinesInFile {

    private static int lines = 0;
    private static int words = 0;
    private static int characters = 0;
    public static void count() throws IOException{

        //Get file path
        File file = new File("D:\\Android\\AndroidStudioProjects\\javaProjects\\src\\IntroductionToJavaProgramming\\chapter14exception_handling_IO/ArrayIndexOutOfBoundsExceptions.java");

        //Count Characters, words, and Lines
        countContent(file);

        System.out.println("\nFile contain " + characters + " characters\n" +
        words + " words\n" + lines + " lines");
    }

    private static void countContent(File file) throws IOException{

        Scanner read = new Scanner(file);
        if (file.exists()){
            //Count @Lines and @Characters
            countLinesAndCharacters(file);

            //Count @Words
            while (read.hasNext()){
                String word = read.next();
                words++;
            }
        }
        read.close();

    }

    private static void countLinesAndCharacters(File file) throws IOException{
        Scanner read = new Scanner(file);
        while (read.hasNext()){
            lines++;
            String line = read.nextLine();
            characters += line.length();
        }

    }
}
