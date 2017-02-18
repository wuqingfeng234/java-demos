package com.git.wuqf;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by wuqf on 17-2-18.
 */
public class ProducerConsumer {

    public static void main(String[] args){
        List<String> eggs=new ArrayList<>(10);
        Producer producer=new Producer(eggs,10);
        Consumer consumer=new Consumer(eggs);
        consumer.start();
        producer.start();
    }
    static class Producer extends Thread{
        private List<String> eggs;
        private int maxSize;

        public Producer(List<String> eggs, int maxSize) {
            this.eggs = eggs;
            this.maxSize = maxSize;
        }
        @Override
        public void run(){
            while (true){
                synchronized (eggs){
                    while (eggs.size()==maxSize){
                        System.out.println("queue is full . producer is waiting for consumer to take some eggs");
                        try {
                            eggs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    Random random=new Random();
                    int i=random.nextInt();
                    System.out.println("produced egg "+i+" .");
                    eggs.add(String.valueOf(i));
                    eggs.notifyAll();
                }
            }
        }
    }
    static class Consumer extends Thread{
        private List<String> eggs;

        public Consumer(List<String> eggs) {
            this.eggs = eggs;
        }
        @Override
        public void run(){
            while (true){
                synchronized (eggs){
                    while (eggs.size()==0){
                        System.out.println("queue is empty . consumer is waiting for producer to producer some eggs");
                        try {
                            eggs.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String i=eggs.remove(0);
                    System.out.println("consumed egg "+i+" .");
                    eggs.notifyAll();
                }
            }
        }
    }
}

