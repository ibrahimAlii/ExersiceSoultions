package IntroductionToJavaProgramming.chapter6_arrays;

import java.util.Scanner;

public class AssignGrades {

    public static void assignGrades(){

        System.out.println("Enter the number of student");
        Scanner scanner = new Scanner(System.in);
        int studentCount = scanner.nextInt();
        int[] gradeArr = new int[studentCount];
        int bestScore = 0;
        System.out.println("Enter " + studentCount + " scores");
        for (int i = 0; i < gradeArr.length; i++) {
            gradeArr[i] = scanner.nextInt();
            if (gradeArr[i] > bestScore)
                bestScore = gradeArr[i];
        }

        for (int i = 0; i < gradeArr.length; i++) {
            if (gradeArr[i] >= bestScore - 10)
                System.out.println("Student " + i + " score is " + gradeArr[i] + " and grade is A");
            else if (gradeArr[i] >= bestScore - 20)
                System.out.println("Student " + i + " score is " + gradeArr[i] + " and grade is B");
            else if (gradeArr[i] >= bestScore - 30)
                System.out.println("Student " + i + " score is " + gradeArr[i] + " and grade is C");
            else if (gradeArr[i] >= bestScore - 40)
                System.out.println("Student " + i + " score is " + gradeArr[i] + " and grade is D");
            else
                System.out.println("Student " + i + " score is " + gradeArr[i] + " and grade is F");
        }
    }
}
