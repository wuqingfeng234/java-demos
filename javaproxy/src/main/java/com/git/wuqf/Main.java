package com.git.wuqf;

import java.lang.reflect.Proxy;

/**
 * @author wuqf
 * @date 2018/11/21
 */
public class Main {
    public static void main(String[] args) {
        HelloImpl hello = new HelloImpl();
        DynamicProxy dynamicProxy = new DynamicProxy(hello);
        Hello o = (Hello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(), dynamicProxy);
        String xx = o.sayHello("xx");
        System.out.println(xx);
    }
}
