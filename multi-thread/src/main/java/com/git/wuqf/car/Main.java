package com.git.wuqf.car;

/**
 * Created by wuqf on 17-2-18.
 */
public class Main {

    public static void main(String[] args){
        Car car=new Car(Status.CLEAN);

        UseCar useCar=new UseCar(car);
        WashCar washCar=new WashCar(car);

        useCar.start();
        washCar.start();
    }
}
