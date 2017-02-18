package com.git.wuqf.helloworld;

/**
 * Created by wuqf on 17-2-18.
 */
public class HelloWorld {

    public static void main(String[] args) {
        HelloWorld hw = new HelloWorld();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                hw.reduce2();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                hw.reduce2();
            }
        });
        t1.start();
        t2.start();
    }

    public void reduce() {
        synchronized (this) {
            int i = 5;
            while (i-- > 0) {
                System.out.println(Thread.currentThread().getName() + ":" + i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public synchronized void reduce2() {
        int i = 5;
        while (i-- > 0) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
