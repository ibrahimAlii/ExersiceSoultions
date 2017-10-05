package IntroductionToJavaProgramming.chapter5_methods;

/*
page 238 - 5.1
 */
public class MathNumberGeneration {

    public static int getNumber(int n) {
        int NUMBERS_PER_LINE = 10, number = 0;
        for (int i = 0; i < n; i++) {
            number = i * (i - 1) / 2;
            if ((i + 1) % NUMBERS_PER_LINE == 0)
                System.out.println(number);
            else
                System.out.print(number);

        }
        return 0;

    }
}
