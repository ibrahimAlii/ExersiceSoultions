package IntroductionToJavaProgramming.chapter25_sorting.external_sort;

import java.io.*;


/**
 * The complete program for sorting int values in largedata.dat and sorting the sorted data in sortedfile.dat
 */
public class SortLargeFile {
    public static final int MAX_ARRAY_SIZE = 100000;
    public static final int BUFFER_SIZE = 100000;
    public static final String F1_FILE = "f1.dat";
    public static final String F2_FILE = "f2.dat";
    public static final String F3_FILE = "f3.dat";

    public static void main(String args[]) throws Exception {
        // Sort largedata.dat to sortedfile.dat
        sort("largedata.dat", "sortedfile.dat");


        // Display the first 100 numbers in the sorted file
        displayFile("sortedfile.dat");
    }

    private static void sort(String sourceFile, String targetFile) throws Exception {

        // Implement Phase 1: Create initial segments
        int numberOfSegments = InitializeSegments.initializeSegments(MAX_ARRAY_SIZE, sourceFile, F1_FILE);

        // Implement Phase 2: merge segments recursively
        merge(numberOfSegments, MAX_ARRAY_SIZE, F1_FILE, F2_FILE, F3_FILE, targetFile);
    }

    private static void merge(int numberOfSegments, int segmentSize, String f1, String f2, String f3,
                              String targetFile) throws Exception {

        if (numberOfSegments > 1) {
            mergeOneStep(numberOfSegments, segmentSize, f1, f2, f3);
            merge((numberOfSegments + 1) / 2, segmentSize * 2, f3, f1, f2, targetFile);
        } else {
            // Rename f1 as the final sorted file
            File sortedFile = new File(targetFile);
            if (sortedFile.exists()) sortedFile.delete();
            new File(f1).renameTo(sortedFile);
        }
    }

    private static void mergeOneStep(int numberOfSegments, int segmentSize, String f1, String f2, String f3)
            throws Exception {

        DataInputStream f1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
        DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));

        // Copy half number of segments from f1.dat to f2.dat
        ExternalSort.copyHalfToF2(numberOfSegments, segmentSize, f1Input, f2Output);
        f2Output.close();

        // Merge remaining segments in f1 with segments in f2 into f3
        DataInputStream f2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
        DataOutputStream f3Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));

        ExternalSort.mergeSegments(numberOfSegments / 2, segmentSize, f1Input, f2Input, f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();
    }

    public static void displayFile(String fileName){

        try {
            DataInputStream input = new DataInputStream(new FileInputStream(fileName));
            for (int i = 0; i < 100; i++)
                System.out.print(input.readInt() + " ");
            input.close();
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }
}
