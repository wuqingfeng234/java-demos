package com.git.wuqf.proxy.spring;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class ProxyTest {
    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "proxyUserService")
    private UserService proxyUserService;

    @Test
    public void testProxy() {
        userService.saveUser("zby", "1234567890");
        proxyUserService.saveUser("zby", "1234567890");
    }
}
