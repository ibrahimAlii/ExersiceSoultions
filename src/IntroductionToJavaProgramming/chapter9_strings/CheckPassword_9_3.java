package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class CheckPassword_9_3 {

    public static void checkPassword() {

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter password
        System.out.print("Enter the password: ");
        String password = input.nextLine();

        System.out.println((isValidPassword(password) ? "Valid Password" : "Not valid password"));
    }

    private static boolean isValidPassword(String password) {
        //Check if password less than 6
        if (password.length() < 6)
            return false;

        //Check if password consists of only uppercase letters and digits && Check if password contains 3 digits at least
        int digitCount = 0;
        for (int i = 0; i < password.length(); i++) {
            if (!Character.isLetterOrDigit(password.charAt(i)))
                return false;

            if (Character.isLetter(password.charAt(i)))
                if (!Character.isUpperCase(password.charAt(i)))
                    return false;

            if (Character.isDigit(password.charAt(i)))
                digitCount++;
        }


        return digitCount >= 3;
    }
}
