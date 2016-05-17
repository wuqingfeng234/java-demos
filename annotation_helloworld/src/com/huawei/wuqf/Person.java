package com.huawei.wuqf;

import java.lang.annotation.*;

/**
 * Created by root on 16-5-17.
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.ANNOTATION_TYPE.TYPE)
public @interface Person {
    String name();
    int age();
}
