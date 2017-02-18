package com.git.wuqf.car;

/**
 * Created by wuqf on 17-2-18.
 */
public class Car {
    private Status status;

    public Car( Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.status = status;
    }
}
