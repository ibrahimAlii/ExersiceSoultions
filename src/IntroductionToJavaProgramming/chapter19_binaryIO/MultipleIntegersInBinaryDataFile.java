package chapter19;

import java.io.*;
import java.util.Random;

public class MultipleIntegersInBinaryDataFile {

    /**
     * Suppose a file contain unspecified integers, find the product of the integers.
     *
     * @param args
     */
    public static void main(String[] args) throws IOException {

        // Create the file with random integer
        File source = new File("Exercise19_03.dat");
        DataOutputStream output =
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream(source)));

        int count = new Random().nextInt(100) * 5;
        int vale;
        while (count > 1) {
            vale = new Random().nextInt() * count;
            output.writeInt(vale);
            count--;
        }
        output.close();


        // Find the product of integers

        DataInputStream input =
                new DataInputStream(new BufferedInputStream(new FileInputStream(source)));

        long result = 1;
        int val;
        while ((val = input.read()) != -1)
            result *= val;

        System.out.println(result);
        input.close();

    }
}
