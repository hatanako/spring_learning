package com.atguigu.ioc_03;

import org.springframework.stereotype.Service;

@Service
public class NewUserServiceImpl implements UserService{
    @Override
    public String show() {
        return "UserServiceImpl show()";
    }
}
