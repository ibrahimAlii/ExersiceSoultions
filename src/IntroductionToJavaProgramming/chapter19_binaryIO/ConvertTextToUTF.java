package chapter19;

import java.io.*;
import java.util.Scanner;

public class ConvertTextToUTF {

    public static void main(String[] dd) throws IOException {

        // Let user write strings
        Scanner scanner = new Scanner(System.in);
        System.out.print("How many student want to insert? ");
        int student = scanner.nextInt();

        DataOutputStream output =
                new DataOutputStream(new BufferedOutputStream(new FileOutputStream("Exersice19_04")));

        for (int i = 0; i < student; i++) {
            output.writeUTF(scanner.nextLine());
        }
        output.close();

        try {

            // Display results
            DataInputStream input = new DataInputStream(
                    new BufferedInputStream(new FileInputStream("Exersice19_04")));

            while (true)
                System.out.print(input.readUTF() + ", ");

        } catch (EOFException ex) {
            System.out.println("All data reached!");
        }
    }
}
