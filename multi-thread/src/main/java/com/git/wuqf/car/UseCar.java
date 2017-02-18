package com.git.wuqf.car;

/**
 * Created by wuqf on 17-2-18.
 */
public class UseCar extends Thread {
    private Car car;

    public UseCar(Car car) {
        this.car = car;
    }

    @Override
    public void run() {

        while (true) {

            synchronized (car) {
                while (car.getStatus() == Status.DIRTY) {
                    try {
                        System.out.println(Thread.currentThread().getName()+":car is dirty. stop using car. notify to clean the car.");
                        car.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println(Thread.currentThread().getName()+":car is used.");
                car.setStatus(Status.DIRTY);
                car.notifyAll();
            }
        }
    }
}
