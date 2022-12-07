package com.git.wuqf;

import java.lang.reflect.Proxy;

/**
 * author wuqf
 * date 2018/11/21
 */
public class Main {
    public static void main(String[] args) {
        ProxyFactory proxyFactory = new ProxyFactory(new HelloImpl());
        Hello proxyInstance = (Hello) proxyFactory.getProxyInstance();
        proxyInstance.sayHello("xx");
    }
}
