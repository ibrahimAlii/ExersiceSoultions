package IntroductionToJavaProgramming.chapter5_methods;

public class FormatInteger {

    public static String format(int number, int width){

        String numberLength = String.valueOf(number);
        String finalNum = "";
        if (width > numberLength.length()){
            for (int i = numberLength.length(); i < width; i++) {
                finalNum += "0";
            }
            return finalNum + number;
        }else
            return String.valueOf(number);

    }
}
