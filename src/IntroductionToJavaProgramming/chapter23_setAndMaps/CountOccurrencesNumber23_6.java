package IntroductionToJavaProgramming.chapter23_setAndMaps;

import java.util.*;

public class CountOccurrencesNumber23_6 {

    public static void main(String[] gg) {

        Scanner input = new Scanner(System.in);


        TreeMap<Integer, Integer> map = new TreeMap<>();

        while (true) {

            int number = input.nextInt();

            if (number == 0) break;


            if (map.get(number) != null) {
                int value = (map.get(number));
                value++;
                map.put(number, value);
            } else {
                map.put(number, 1);
            }

        }

        int max = Collections.max(map.values());
        Set keys = map.keySet();

        for (Object key : keys) {
            Integer value = map.get(key);
            if (value.equals(max))
                System.out.println("Number " + key + " Occured most");
        }
    }


}
