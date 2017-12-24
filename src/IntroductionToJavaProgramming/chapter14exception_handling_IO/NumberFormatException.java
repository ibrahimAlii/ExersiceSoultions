package IntroductionToJavaProgramming.chapter14exception_handling_IO;

import java.util.Scanner;

public class NumberFormatException {

    public static void numberFormatException(){

        String result = "";
        boolean legal = true;
        Scanner input = new Scanner(System.in);
        do {
            try {


                String calc = input.nextLine();
                switch (calc.charAt(2)) {
                    case '+':
                        result = String.valueOf(Integer.parseInt(String.valueOf(calc.charAt(0))) + Integer.parseInt(String.valueOf(calc.charAt(4))));
                        break;
                    case '-':
                        result = String.valueOf(Integer.parseInt(String.valueOf(calc.charAt(0))) - Integer.parseInt(String.valueOf(calc.charAt(4))));
                        break;
                    case '*':
                        result = String.valueOf(Integer.parseInt(String.valueOf(calc.charAt(0))) * Integer.parseInt(String.valueOf(calc.charAt(4))));
                        break;

                }
            }catch (java.lang.NumberFormatException ex){
                System.out.println("Wrong Input: " +
                        ex.getMessage().substring(ex.getMessage().indexOf("\"") + 1,
                                ex.getMessage().lastIndexOf("\"")));
                legal = false;
            }
            System.out.println(result);
        }while (legal);
    }
}
