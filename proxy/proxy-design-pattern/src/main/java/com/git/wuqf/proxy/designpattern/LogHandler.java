package com.git.wuqf.proxy.designpattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * Created by sdzn-dsj on 2016/12/12.
 */
public class LogHandler implements InvocationHandler {
    Object object;

    LogHandler(Object object) {
        this.object = object;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        this.doBefore();
        Object o = method.invoke(object, args);
        this.doAfter();
        return o;
    }

    public void doBefore() {
        System.out.println("do this before");
    }

    public void doAfter() {
        System.out.println("do this after");
    }
}
