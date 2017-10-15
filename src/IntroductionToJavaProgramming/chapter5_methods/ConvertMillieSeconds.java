package IntroductionToJavaProgramming.chapter5_methods;


public class ConvertMillieSeconds {

    public static java.lang.String convertMillis(long value){
        java.lang.String convertedMinutesAndSeconds = "";
        value /= 1000;

        for (int i = 0; i < 2; i++) {
            convertedMinutesAndSeconds = ":" + value % 60 + convertedMinutesAndSeconds;
            value /= value;
        }

        return value + convertedMinutesAndSeconds;
    }
}
