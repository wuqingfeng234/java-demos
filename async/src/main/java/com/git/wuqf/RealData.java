package com.git.wuqf;

import java.util.Observable;

/**
 * Created by sdzn-dsj on 2016/11/29.
 */
public class RealData extends Observable implements Data {

    private String content;

    public RealData() {

    }

    public void createRealData2(int count, char c) {
        System.out.println("        making com.git.wuqf.RealData(" + count + ", " + c
                + ") BEGIN");
        char[] buffer = new char[count];
        for (int i = 0; i < count; i++) {
            buffer[i] = c;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        }
        System.out.println("        making com.git.wuqf.RealData(" + count + ", " + c
                + ") END");
        this.content = new String(buffer);

        //真实数据准备完毕了，通知FutureData2说数据已经准备好了.
        setChanged();//必须先设置本对象的状态发生了变化，并且通知所有的观察者
        notifyObservers("Finished");
    }

    public String getContent() {
        return content;
    }
}

