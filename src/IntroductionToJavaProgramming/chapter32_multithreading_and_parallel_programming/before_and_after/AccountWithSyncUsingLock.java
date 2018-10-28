package IntroductionToJavaProgramming.chapter32_multithreading_and_parallel_programming.before_and_after;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AccountWithSyncUsingLock {

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

    public static class AddPennyTask implements Runnable {

        @Override
        public void run() {
            account.deposit(1);
        }
    }

    public static class Account {
        private int balance = 0;
        private static Lock lock = new ReentrantLock(); // <<===

        public int getBalance() {
            return balance;
        }

        public void deposit(int amount) {
            lock.lock();
            try {
                int newBalance = balance + amount;
                // This delay is deliberately added to magnify the data-corruption problem and make it easy to see

                Thread.sleep(5);
                balance = newBalance;
            } catch (InterruptedException ex) {

            } finally {
                lock.unlock(); // <<===
            }
        }
    }
}
