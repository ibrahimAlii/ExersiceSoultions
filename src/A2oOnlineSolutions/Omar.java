package A2oOnlineSolutions;

import java.util.Scanner;

/*
Problem Statement:

If you are here because of A2OJ Code Battle, please sign up for the tournament here.

Omar is the youngest programer in the world, he is just 14 months old (when this problem was added), and he has just decided to write his first program.

This program is very simple, the program should be able to read 2 numbers and print the sum of them.

Can you help Omar by writing a correct program so that he can use it to check if his program is correct or not?


Input Format:
Your program will be tested on one or more test cases. The first line of the input will be a single integer T, the number of test cases (1 ≤ T ≤ 100). Followed by the test cases, each test case is described in one line which contains 2 integers separated by a single space X Y (1 ≤ X,Y ≤ 100). X and Y are the 2 numbers which you should print the sum of them.


Output Format:
For each test case, print a single line contains a single integer which is the sum of X and Y.


Sample Input:
5
22 12
23 12
1 1
2 3
100 100


Sample Output:
34
35
2
5
200

 */
public class Omar {
    public static void getSum(){

        Scanner scanner = new Scanner(System.in);
        int x = 0,y,a;
        a = scanner.nextInt();
        for (int i = 0; i < a; i++) {
            x= scanner.nextInt();
            y= scanner.nextInt();
            System.out.println(x + y);
        }
    }
}
