package IntroductionToJavaProgramming.chapter25_sorting.external_sort;

import java.io.DataInputStream;
import java.io.DataOutputStream;

public class ExternalSort {

    // This method copies the first half of the segments in f1.dat to f2.dat
    public static void copyHalfToF2(int numberOfSegments, int segmentSize, DataInputStream f1, DataOutputStream f2) throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++)
            f2.writeInt(f1.readInt());
    }

    // This method merges a pair of segments in f1.dat and f2.dat
    public static void mergeSegments(int numberOfSegments, int segmentSize, DataInputStream f1, DataInputStream f2,
                                     DataOutputStream f3) throws Exception {

        // Merge two segments
        for (int i = 0; i < numberOfSegments; i++)
            mergeTwoSegments(segmentSize, f1, f2, f3);

        // Extra segments
        while (f1.available() > 0)
            f3.writeInt(f1.readInt());
    }

    // This method merge two segments
    private static void mergeTwoSegments(int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3)
            throws Exception {

        int intFromF1 = f1.readInt(); // read from f1
        int intFromF2 = f2.readInt(); // read from f2
        int f1Count = 1;
        int f2Count = 1;

        while (true) {
            if (intFromF1 < intFromF2) {
                // write to f3
                f3.writeInt(intFromF1);
                if (f1.available() == 0 || f1Count++ >= segmentSize) {
                    f3.writeInt(intFromF2);
                    break; // segment in f1 finished
                } else
                    intFromF1 = f1.readInt();

            } else {
                f3.writeInt(intFromF2); // write to f3
                if (f2.available() == 0 || f2Count++ >= segmentSize) {
                    f3.writeInt(intFromF1);
                    break; // segment in f2 finished
                } else
                    intFromF2 = f2.readInt();
            }
        }

        // remaining f1 segments
        while (f1.available() > 0 && f1Count++ < segmentSize)
            f3.writeInt(f1.readInt());

        // remaining f2 segment
        while (f2.available() > 0 && f2Count++ < segmentSize)
            f3.writeInt(f2.readInt());
    }
}
