package IntroductionToJavaProgramming.chapter9_strings;

import java.util.Scanner;

public class BinaryToHex_9_4 {

    public static void binaryToHex(){

        Scanner input = new Scanner(System.in);

        //Prompt the user to enter binary value
        System.out.print("Enter binary value: ");
        String binaryValue = input.nextLine();

        String hexValue = binaryToHex(binaryValue);

        //Display result
        System.out.println(hexValue);
    }

    private static String binaryToHex(String binary) {

        int digitNumber = 1;
        int sum = 0;
        String hexValue = "";
        for(int i = 0; i < binary.length(); i++){
            if(digitNumber == 1)
                sum+=Integer.parseInt(binary.charAt(i) + "")*8;
            else if(digitNumber == 2)
                sum+=Integer.parseInt(binary.charAt(i) + "")*4;
            else if(digitNumber == 3)
                sum+=Integer.parseInt(binary.charAt(i) + "")*2;
            else if(digitNumber == 4 || i < binary.length()+1){
                sum+=Integer.parseInt(binary.charAt(i) + "")*1;
                digitNumber = 0;
                if(sum < 10)
                    hexValue += sum;
                else if(sum == 10)
                    hexValue += "A";
                else if(sum == 11)
                    hexValue += "B";
                else if(sum == 12)
                    hexValue += "C";
                else if(sum == 13)
                    hexValue += "D";
                else if(sum == 14)
                    hexValue += "E";
                else if(sum == 15)
                    hexValue += "F";
                sum=0;
            }
            digitNumber++;
        }
        return  hexValue;
    }
}
