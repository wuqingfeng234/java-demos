package com.git.wuqf.helloworld;

/**
 * Created by wuqf on 17-2-18.
 */
public class Common {

    public static void main(String[] args) {

        Common common = new Common();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                common.reduce();
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                common.reduce();
            }
        });
        t1.start();
        t2.start();
    }

    public void reduce() {
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
