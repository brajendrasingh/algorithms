package com.sugya.thread;

public class PrintSequence {
    private static int number = 1;
    private static final int MAX = 10;
    private static final Object lock = new Object();

    public static void main(String[] args) {
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                printNumbers(1);
//            }
//        }, "T1");
        Thread t1 = new Thread(() -> printNumbers(1), "T1");
        Thread t2 = new Thread(() -> printNumbers(2), "T2");
        Thread t3 = new Thread(() -> printNumbers(0), "T3");
        t1.start();
        t2.start();
        t3.start();
    }

    static void printNumbers(int remainder) {
        while (true) {
            synchronized (lock) {
                while (number <= MAX && number % 3 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                }
                if (number > MAX) {
                    lock.notifyAll();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + " -> " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}
