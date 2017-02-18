package com.git.wuqf.car;

/**
 * Created by wuqf on 17-2-18.
 */
public class WashCar extends Thread{
    private Car car;

    public WashCar(Car car) {
        this.car = car;
    }

    @Override
    public void run() {

        while (true) {
            synchronized (car) {
                while (car.getStatus() == Status.CLEAN) {
                    try {
                        System.out.println(Thread.currentThread().getName()+":car is clean. stop cleaning car. notify to use the car.");
                        car.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+":car is cleaned.");
                car.setStatus(Status.CLEAN);
                car.notifyAll();
            }
        }
    }
}
