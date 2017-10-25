package IntroductionToJavaProgramming.chapter6_arrays;

public class RandomNumbers {

    public static int getRandom(int... numbers) {
        int num;	// Random number
        boolean isExcluded; // Is the number excluded
        do {
            isExcluded = false;
            num = 1 + (int)(Math.random() * 5);
            for (int e: numbers) {
                if (num == e)
                    isExcluded = true;
            }
        } while (isExcluded); // Test if number is Excluded
        return num;
    }

}
