package com.git.wuqf;

public class Novisibility {
    private static boolean ready = false;
    private static int number = 0;

    private static class ReaderThread extends Thread {
        @Override
        public void run() {
            while (!ready) {
                System.out.print(ready);
                Thread.yield();
            }
            System.out.print(number);
        }
    }

    public static void main(String[] arsg) throws InterruptedException {
        new ReaderThread().start();
        number = 42;
        ready = true;
        Thread.currentThread().join();
    }
}
