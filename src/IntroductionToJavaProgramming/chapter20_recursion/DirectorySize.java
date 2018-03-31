package IntroductionToJavaProgramming.chapter20_recursion;

import java.io.File;

public class DirectorySize {

    public static void main(String[] ab) {

        System.out.println(getSize(new File("C://")));
    }

    public static long getSize(File file) {
        long size = 0;

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (int i = 0; files != null && i < files.length; i++) {
                size += getSize(files[i]); // Recursive call
            }
        } else size += file.length(); // Base case

        return size;
    }
}
