package IntroductionToJavaProgramming.chapter32_multithreading_and_parallel_programming;

public class TaskThreadDemo {

    public static void main(String[] args) {
        PrintChar printA = new PrintChar('a', 100);
        PrintChar printB = new PrintChar('b', 100);
        PrintNum printNum = new PrintNum(100);

        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(printNum);

        thread3.start();
        thread1.start();
        thread2.start();
    }


}

class PrintChar implements Runnable {
    public char aChar;
    public int times;

    public PrintChar(char c, int times) {
        aChar = c;
        this.times = times;
    }

    @Override
    public void run() {
        for (int i = 0; i < times; i++) {
            System.out.print(aChar);
        }
    }
}

class PrintNum implements Runnable {
    public int lastNum;

    public PrintNum(int n) {
        lastNum = n;
    }

    @Override
    public void run() {
        Thread thread = new Thread(new PrintChar('c', 40));
        thread.start();
        try {
            for (int i = 0; i <= lastNum; i++) {
                System.out.print(" " + i);
                if (i == 50) {

                    thread.join();
                }
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
