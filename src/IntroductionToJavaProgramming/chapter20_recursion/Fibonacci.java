package chapter20;

public class Fibonacci {

    public static void main(String[] aa){

        System.out.println(fibonacci(8));
    }

    public static long fibonacci(int index){
        if (index == 0)
            return 0;
        else if (index == 1)
            return 1;
        else return fibonacci(index - 1) + fibonacci(index - 2);
    }
}
