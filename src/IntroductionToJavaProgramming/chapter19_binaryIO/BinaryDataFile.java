package chapter19;

import java.io.*;

public class CreateBinaryDataFile {

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
