package com.git.wuqf;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by sdzn-dsj on 2016/12/12.
 */
public class TThread {

    public static void main(String[] args) {
        int count = 200000;
        long startTime = System.currentTimeMillis();
        List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread() {
                public void run() {
                    l.add(random.nextInt());
                }
            };
            thread.start();


            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }
}
