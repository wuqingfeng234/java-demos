package com.git.wuqf.proxy.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class MyInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("pre");
        Object o = methodInvocation.proceed();
        System.out.println("post");
        return o;
    }
}
