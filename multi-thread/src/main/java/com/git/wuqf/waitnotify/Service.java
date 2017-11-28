package com.git.wuqf.waitnotify;

public class Service {
    public void waitMethod(Object lock) {

        synchronized (lock) {
            System.out.println("begin wait(), ThreadName=" + Thread.currentThread().getName());
            try {
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end wait(),ThreadName=" + Thread.currentThread().getName());
        }
    }

    public void synNotifyMethod(Object lock) {
        synchronized (lock) {
            System.out.println("begin notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
            lock.notify();
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("end notify() ThreadName=" + Thread.currentThread().getName() + " time=" + System.currentTimeMillis());
        }
    }
}
