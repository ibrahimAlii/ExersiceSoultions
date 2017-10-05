package IntroductionToJavaProgramming.chapter5_methods;

public class DisplayPattern {
    public static void displayPattern(int n){
        String carrier = "";
        for (int i = 1; i <= n; i++) {
            carrier = carrier + (int) i;
            System.out.println(carrier);
        }
    }
}
