package com.git.wuqf.waitnotify;

public class Main {
    public static void main(String[] args) {
        Object lock = new Object();
        WaitThread waitThread = new WaitThread(lock);
        NotifyThread notifyThread = new NotifyThread(lock);
        waitThread.start();
        notifyThread.start();
    }
}
