package IntroductionToJavaProgramming.chapter15_abstractClassesandInterfaces;

import java.util.ArrayList;

public class SortArrayList {

    /**
     *  We used the Selection algorithm : https://en.wikipedia.org/wiki/Selection_algorithm
     * function select(list[1..n], k)
       for i from 1 to k
           minIndex = i
           minValue = list[i]
               for j from i+1 to n
                   if list[j] < minValue
                   minIndex = j
                   minValue = list[j]
                   swap list[i] and list[minIndex]
      return list[k]
     */

    public static ArrayList sortArrayList(ArrayList arrayList){

        int minIndex, minValue;
        for (int i = 0; i < arrayList.size(); i++) {
            minIndex = i;
            minValue = (int) arrayList.get(i);
            for (int j = i + 1; j < arrayList.size(); j++) {
                if ((int)arrayList.get(j) < minValue){
                    minIndex = j;
                    minValue = (int) arrayList.get(j);
                }
            }
            if (minIndex != i){
                arrayList.set(minIndex, arrayList.get(i));
                arrayList.set(i, minValue);
            }
        }
        return arrayList;
    }

}
