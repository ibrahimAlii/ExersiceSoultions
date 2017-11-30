package IntroductionToJavaProgramming.basics;

public class MathCombinations {

    public void getCombinations(){

        for(int i = 0; i < (1 << 3); i++) {
            System.out.println(i < (1 << 3));
            for(int j = 3 - 1; j >= 0; j--) {
                if((i & (1 << j)) != 0) {
                    System.out.print(1);
                } else {
                    System.out.print(0);
                }
            }
            System.out.println();
        }
    }
}
