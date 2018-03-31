package IntroductionToJavaProgramming.chapter19_binaryIO;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class StoreObjectsAndArraysInFile {

    public static void main(String[] data) throws IOException {

        // Store objects and arrays
        ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("Exercise19_05"));

        int[] arr = {1, 2, 3, 4};
        Date date = new Date();
        double value = 55.66;

        output.writeDouble(value);
        output.writeObject(arr);
        output.writeObject(date);

        output.close();

    }
}

