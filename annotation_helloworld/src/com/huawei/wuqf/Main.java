package com.huawei.wuqf;

/**
 * Created by root on 16-5-17.
 */
@Person(name="xiaoming",age=6)
public class Main {
    public static void print(Class c)
    {
        System.out.println(c.getName());
        Person person=(Person)c.getAnnotation(Person.class);
        if(person!=null)
        {
            System.out.print("the name of person is "+person.name());
        }
    }
    public static void main(String[] args)
    {
        Main.print(Main.class);
    }
}
