package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {

    public static void launchGame() throws IOException{

        //Get file path
        File file = new File("D:\\Android\\AndroidStudioProjects\\javaProjects/hangman.txt");

        //Get random word
        String randomWord = getRandomWord(file);

        System.out.println(randomWord);
        //Hide word
        String hiddenWord = hideWord(randomWord);

        //Start guessing
        int missedCount = guessing(hiddenWord, randomWord);

        //Show result
        System.out.println("The word is " + randomWord +
                (missedCount == 0 ? "You didn't missed" :
                        (missedCount == 1) ? "You missed one time" : "You missed " + missedCount + " times"));
    }

    private static int guessing(String hiddenWord, String randomWord) {

        Scanner in = new Scanner(System.in);
        char guessedChar;
        int missed = 0;

        do {
            System.out.println("Enter one character: ");
            //TODO check if character is already added before
            guessedChar = in.nextLine().charAt(0);
            if (!randomWord.contains(guessedChar + ""))
                missed++;
            else System.out.println(hiddenWord = showReplacedChart(randomWord, hiddenWord, guessedChar));
        }while (!matched(hiddenWord, randomWord));

        return missed;
    }

    private static String showReplacedChart(String randomWord, String hiddenWord, char guessedChar) {

        StringBuilder builder = new StringBuilder(hiddenWord);
        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == guessedChar)
                builder.setCharAt(i, guessedChar);
        }
        return builder.toString();
    }

    private static boolean matched(String hiddenWord, String randomWord) {
        return hiddenWord.equals(randomWord);
    }


    private static String hideWord(String randomWord) {
        String hiddenWord = "";
        for (int i = 0; i < randomWord.length(); i++) {
            hiddenWord += '*';
        }
        return hiddenWord;
    }

    private static String getRandomWord(File file) throws IOException{
        Scanner read = new Scanner(file);
        ArrayList<String> list = new ArrayList<>();

        while (read.hasNext()){
            list.add(read.next());
        }
        read.close();
        return list.get((int) (Math.random() * list.size()));
    }
}
