package com.git.wuqf.waitnotify;

public class WaitThread extends Thread {
    private Object lock;
    public WaitThread(Object lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.waitMethod(lock);
    }
}
