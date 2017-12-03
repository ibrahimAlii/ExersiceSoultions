package IntroductionToJavaProgramming.chapter5_methods;



public class RandomPatteren {


    public static void getPattern() {


        Integer DEFAULT_ROW_LEN = 61;
        Integer NUMBER_OF_ROWS = 1000;
        char DEFAULT_ROW_CONTENT = '.';
        Double SPEED = 2.8;

// Preparing row of dots
        StringBuilder row = new StringBuilder();
        for (int i = 0; i < DEFAULT_ROW_LEN; i++) {
            row.append(DEFAULT_ROW_CONTENT);
        }

        for (double i = 0; i < NUMBER_OF_ROWS; i += SPEED) {

            // Loop progress
            double relativeProgress = i / DEFAULT_ROW_LEN.doubleValue();

            // In projection on a circle
            double circleProgress  = relativeProgress * Math.PI * 2.0;

            // Remember that sin goes from -1 to +1, but we need to fit the curve within 0 to +1
            double consoleProgress  = (Math.sin(circleProgress) + 1.0) / 2.0;

            // Exact index in the row to highlight
            double  exactPosition = (double) (consoleProgress * DEFAULT_ROW_LEN);
            row.setCharAt((int) exactPosition, 'X');

            // Print current progress and restore defaults
            System.out.println(row);
            row.setCharAt((int) exactPosition, DEFAULT_ROW_CONTENT);
        }


    }




}
