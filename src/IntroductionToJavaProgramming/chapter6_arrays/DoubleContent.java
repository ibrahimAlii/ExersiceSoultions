package IntroductionToJavaProgramming.chapter6_arrays;

/*
  double the numbers
 */
public class DoubleContent {

    public static double[] doubleIt(double[] array){

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i] * 2;
        }
        return array;
    }
}
