package com.git.wuqf.proxy.spring;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public void saveUser(String username, String password) {
        System.out.println("save user,username is " + username + "password is " + password);
    }
}
