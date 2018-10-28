package IntroductionToJavaProgramming.chapter32_multithreading_and_parallel_programming;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorDemo {


    public static void main(String[] args){

        //ExecutorService executor = Executors.newFixedThreadPool(3); // Creating a thread pool executor with a total of three threads maximum.

        //ExecutorService executor = Executors.newFixedThreadPool(1); // The three runnable tasks wil be executed [sequentially].

        ExecutorService executor = Executors.newCachedThreadPool(); // A new Thread will be created for each waiting task.

        executor.execute(new PrintChar('a', 100));
        executor.execute(new PrintChar('b', 100));
        executor.execute(new PrintNum(100));

        executor.shutdown();
    }
}
