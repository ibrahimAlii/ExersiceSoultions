package IntroductionToJavaProgramming.chapter32_multithreading_and_parallel_programming.before_and_after;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class AccountWithoutSync {
    private static Account account = new Account();

    public static void main(String[] main) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for (int i = 0; i < 100; i++) {
            executor.execute(new AddPennyTask());
        }

        executor.shutdown();

        // Wait until all tasks are finished
        while (!executor.isTerminated()) {
        }

        System.out.println("What is balance? " + account.getBalance());
    }

    private static class AddPennyTask implements Runnable {

        @Override
        public void run() {
            account.deposit(1);
        }
    }

    private static class Account {
        private int balance = 0;

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            int newBalance = balance + amount;
            // This delay is deliberately added to magnify the data-corruption problem and make it easy to see
            try {
                Thread.sleep(5);
            } catch (InterruptedException ex) {

            }
            balance = newBalance;
        }
    }
}
