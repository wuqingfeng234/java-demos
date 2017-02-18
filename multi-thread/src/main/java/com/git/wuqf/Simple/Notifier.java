package com.git.wuqf.Simple;

/**
 * Created by wuqf on 17-2-18.
 */
public class Notifier implements Runnable{
    private Message message;

    public Notifier(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String name=Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(10000);
            synchronized (message){
                message.setMessage("notifier work done");
                message.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
