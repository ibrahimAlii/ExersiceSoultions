package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class GameHangman_9_25 {

    private static String[] WORDS = {"programming", "fish", "cairo", "arabs", "quraan", "sunnah",
            "editor", "photography", "artist", "software", "write", "read", "gaming",
            "lunch", "participate", "lunch", "dinner", "house", "books", "animals"};

    public static void startGame() {

        Scanner input = new Scanner(System.in);

        //Choose a random word
        String word = chooseWord();

        //Start guessing game with chosen word and count missed times
        int missed = startGuessing(word, input);

        //Display result
        System.out.println("The word is " + word + (missed == 0 ? " you are correct" : " you missed " + (missed == 1 ? " one time" : " " + missed + " times")));

        //Ask for another game
        askForAnotherGame(input);
    }

    private static void askForAnotherGame(Scanner input) {
        System.out.print("Do you want to start another word? Enter y or no>");
        char gameCase = input.nextLine().charAt(0);
        if (gameCase == 'y')
            startGame();
        else
            System.exit(1);
    }

    private static int startGuessing(String originalWord, Scanner input) {
        StringBuilder replacedWord = new StringBuilder(hideRealWord(originalWord));
        int missing = 0;
        boolean wrongGuessing;
        int wordLength = originalWord.length();

        while (wordLength > 0) {
            System.out.print("(Guess) Enter a letter in word " + replacedWord.toString() + " ");
            char ch = input.nextLine().charAt(0);
            wrongGuessing = true;
            for (int j = 0; j < originalWord.length(); j++) {
                if (originalWord.charAt(j) == ch) {
                    replacedWord.setCharAt(j, ch);
                    wrongGuessing = false;
                    wordLength--;
                }
                if (ch == replacedWord.charAt(j))
                    System.out.println(ch  + " Already in the word");
            }
            if (wrongGuessing) {
                System.out.println(ch + " is not in the word");
                missing++;
            }

        }
        return missing;
    }

    private static String hideRealWord(String originalWord) {
        //System.out.println(originalWord);
        for (int i = 0; i < originalWord.length(); i++) {
            char ASTERISK = '*';
            originalWord = originalWord.replace(originalWord.charAt(i), ASTERISK);
        }
        return originalWord;
    }

    private static String chooseWord() {
        return WORDS[(int) (Math.random() * WORDS.length)];
    }
}
