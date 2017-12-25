package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ReformatJavaSourceCode {

    public static void reformat() throws IOException {

        //Get File Path
        File file = new File("D:\\Android\\AndroidStudioProjects\\javaProjects/test.txt");

        //Read file source
        ArrayList source = new ArrayList<>();
        if (file.exists() && file.length() > 1) {
            source = formatFileSource(file);
        }

        //Write new Source
        if (file.exists()){
            writeNewFormat(file, source);
        }
    }

    private static void writeNewFormat(File file, ArrayList source) throws IOException {
        PrintWriter writer = new PrintWriter(file);
        for (Object aSource : source) {
            writer.println(aSource);
        }
        writer.close();
    }

    private static ArrayList formatFileSource(File file) throws IOException {
        //Get Input
        Scanner read = new Scanner(file);
        ArrayList source = new ArrayList();
        //
        String str = "", normalString = "";
        while (read.hasNext()) {
            str = read.nextLine();
            if (str.length() > 0 &&
                    str.charAt(str.length() - 1) == '{'){
                source.add(normalString.concat(" {"));
                normalString = read.nextLine();
            } else{
                source.add(normalString);
                normalString = str;
            }

        }
        source.add(normalString);
        read.close();
        return source;
    }
}
