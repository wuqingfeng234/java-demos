package com.git.wuqf;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by sdzn-dsj on 2016/12/12.
 */
public class PJoinQueue {

    public static void main(String[] args){
        int count=200000;
        long startTime=System.currentTimeMillis();
        final List<Integer> l=new LinkedList();
        ThreadPoolExecutor tp=new ThreadPoolExecutor(1,1,60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>(count));
        final Random random=new Random();

        for(int i=0;i<count;i++){
            tp.execute(new Runnable() {
                public void run() {
                    l.add(random.nextInt());
                }
            });
        }
        tp.shutdown();
        try{
            tp.awaitTermination(1,TimeUnit.DAYS);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-startTime);
        System.out.println(l.size());
    }


}
