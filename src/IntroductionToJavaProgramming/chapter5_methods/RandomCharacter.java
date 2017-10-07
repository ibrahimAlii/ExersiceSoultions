package IntroductionToJavaProgramming.chapter5_methods;

/*
This class is to generate random character, digits...
 */
public class RandomCharacter {
    private static char getRandomCharacter(char ch1, char ch2) {
        return (char) (ch1 + Math.random() * (ch2 - ch1 + 1));
    }

    // Generate random lowercase characters
    public static char getRandomLowerCase() {
        return getRandomCharacter('a', 'z');
    }

    //Generate a random uppercase characters
    public static char getRandomUperCase() {
        return getRandomCharacter('A', 'Z');
    }

    //Generate a random digit number
    public static char getRandomDigit() {
        return getRandomCharacter('1', '9');
    }

    public static char getRandomCharacter() {
        return getRandomCharacter('\u0000', '\uFFFF');
    }

    public static void printRandomWhatEver(int NUMBER_OF_CHARACTER,
                                    int NUMBER_OF_LINES,
                                    char char1, char char2) {
        int DIFFERENCE_SQUARE = 4;
        char oldChar, newChar, random;
        for (int i = 0; i < NUMBER_OF_CHARACTER; i++) {
            random = getRandomCharacter(char1, char2);
            if ((i + 1) % NUMBER_OF_LINES == 0) { // new line each new NUMBER_OF_LINE
                System.out.println(random);
            } else {
                System.out.print(random);
            }
        }

    }
}
