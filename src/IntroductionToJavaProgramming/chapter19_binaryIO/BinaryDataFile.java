package IntroductionToJavaProgramming.chapter19_binaryIO;

import java.io.*;

public class BinaryDataFile {

    public static void main(String[] args) throws IOException {

        File sourceFile = new File("Exercise19_01.txt");

        if (sourceFile.exists()){
            DataOutputStream output =
                    new DataOutputStream(new BufferedOutputStream(new FileOutputStream(sourceFile)));

            for (int i = 0; i < 200; i++) {
                output.writeInt(i);
            }

            output.close();
        }

    }
}
