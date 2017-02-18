package com.git.wuqf.Simple;

/**
 * Created by wuqf on 17-2-18.
 */
public class Waiter implements Runnable{
    private Message message;

    public Waiter(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        synchronized (message){
            System.out.println(name+" waiting to get notifier at time"+System.currentTimeMillis());
            try {
                message.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name+" get notifier at time "+System.currentTimeMillis());
            System.out.println(name+" processed message is "+message.getMessage());
        }
    }
}
