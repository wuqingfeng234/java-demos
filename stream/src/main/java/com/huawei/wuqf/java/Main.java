package com.huawei.wuqf.java;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by wuqf on 16-6-3.
 */
public class Main {
    public static void main(String[] args) {
        word();
    }

    public static void stream() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> stream = numbers.stream();
        stream.filter((x) -> {
            return x % 2 == 0;
        }).map(x -> {
            return x * x;
        }).forEach(System.out::println);
    }

    public static void word() {
        String ss = "Hello";
        String[] aa = ss.split("");
        String[] bb = {"H", "e", "l", "l", "o"};
        String[] strings = {"Hello", "World"};

        Stream<String[]> stream1 = Arrays.asList(strings).stream().
                map(str -> str.split(""));
        Stream<String> stringStream = stream1.flatMap(strings1 -> Arrays.stream(strings1));


        List<String> ls = stringStream.collect(Collectors.toList());
        System.out.println("xxx");
    }
}

