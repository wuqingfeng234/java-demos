package com.git.wuqf.Simple;

/**
 * Created by wuqf on 17-2-18.
 */
public class Main {
    public static void main(String[] args){
        Message message=new Message("init message");
        Waiter waiter=new Waiter(message);
        Notifier notifier=new Notifier(message);
        new Thread(waiter,"waiter").start();
        new Thread(notifier,"notifier").start();
        System.out.println("All the threads are started");
    }
}
