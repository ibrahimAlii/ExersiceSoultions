package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ShuffleArrayList {
    /**
     * Using Fisher-Yates algorithms : https://en.wikipedia.org/wiki/Fisher%E2%80%93Yates_shuffle
     *
     * -- To shuffle an array a of n elements (indices 0..n-1):
     * for i from n−1 downto 1 do
     * j ← random integer such that 0 ≤ j ≤ i
     * exchange a[j] and a[i]
     */

    public static void shuffleArray(ArrayList arrayList){
        ArrayList shuffled = new ArrayList();
        Random rnd = ThreadLocalRandom.current();
        for (int i = arrayList.size() - 1; i > 1; i--) {
            int j = rnd.nextInt(i);
            arrayList.set(j, arrayList.get(i));

        }
    }
}
