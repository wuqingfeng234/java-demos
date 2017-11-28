package com.git.wuqf.waitnotify;

public class NotifyThread extends Thread{
    private Object lock;
    public NotifyThread(Object lock){
        this.lock=lock;
    }

    @Override
    public void run() {
        Service service=new Service();
        service.synNotifyMethod(lock);
    }
}
