package IntroductionToJavaProgramming.chapter25_sorting.external_sort;

import java.io.*;
import java.util.Arrays;

/**
 * A helper class to reads each segment of data from a file, sorts the segments, and stores the sorted segments into a new file
 */
public class InitializeSegments {

    // Sort the original file into sorted segments
    // The method return the number of segments
    public static int initializeSegments(int segmentSize, String originalFile, String temporaryFile) throws Exception {
        int[] list = new int[segmentSize];

        // Original file
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
        // File with sorted segments
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(temporaryFile)));

        int numberOfSegments = 0;
        while (input.available() > 0) {
            numberOfSegments++;
            int i = 0;
            for (; input.available() > 0 && i < segmentSize; i++)
                list[i] = input.readInt();

            // Sort an array list[0...i-1] (Sort a segment)
            Arrays.sort(list, 0, i);

            // Write the array to temporary file
            // Out put the file
            for (int j = 0; j < i; j++)
                output.writeInt(list[j]);
        }

        input.close();
        output.close();

        return numberOfSegments;
    }
}
