package com.git.wuqf.performance;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        int count = 100000;
        threadpool(count);
        thread(count);
    }

    private static void threadpool(int count) {
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        ThreadPoolExecutor tp = new ThreadPoolExecutor(1, 1, 60, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(count));
        for (int i = 0; i < count; i++) {
            tp.execute(new Runnable() {
                @Override
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        tp.shutdown();
        try {
            tp.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis() - startTime);
        System.out.println(l.size());
    }

    private static void thread(int count) {
        long startTime = System.currentTimeMillis();
        final List<Integer> l = new LinkedList<>();
        final Random random = new Random();
        for (int i = 0; i < count; i++) {
            Thread thread = new Thread() {
                @Override
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
