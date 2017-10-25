package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class SortingStudent {

    public static void sortStudents(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How much student?");
        int count = scanner.nextInt();
        int[] studentScores = new int[count];
        String[] studentNames = new String[count];
        for (int i = 0; i < count; i++) {
            scanner.nextLine();
            System.out.println("Student name ?");
            studentNames[i] = scanner.nextLine();
            System.out.println("Student score ?");
            studentScores[i] = scanner.nextInt();
        }

        sortingStudent(studentScores, studentNames);
        for (int i = 0; i < count; i++) {
            System.out.println(" " + studentNames[i] + " " + studentScores[i] + " \n");
        }

    }

    public static void sortingStudent(int[] listScores, String[] listNames){

        for (int i = 0; i < listScores.length - 1; i++) {
            int currentMin = listScores[i];
            String currentName = listNames[i];
            int currentMinIndex = i;

            for (int j = i + 1; j < listScores.length; j++) {
                if (currentMin < listScores[j]){
                    currentName = listNames[i];
                    currentMin = listScores[j];
                    currentMinIndex = j;
                }
            }

            if (currentMinIndex != i){
                listScores[currentMinIndex] = listScores[i];
                listNames[currentMinIndex] = listNames[i];
                listScores[i] = currentMin;
                listNames[i] = currentName;
            }
        }
    }
}
