package com.git.wuqf;

public class HelloImpl implements Hello {
    @Override
    public String sayHello(String name) {
        System.out.println("hello~~~" + name);
        return "hello~~~" + name;
    }
}
