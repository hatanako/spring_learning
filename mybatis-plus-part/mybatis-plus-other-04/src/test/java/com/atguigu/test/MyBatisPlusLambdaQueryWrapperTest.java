package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class MyBatisPlusLambdaQueryWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test_01(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();

        //链式调用
        queryWrapper.like("name", "a").between("age", 20, 30)
                .isNotNull("email");

        //Lambda
        LambdaQueryWrapper<User> lambdaQueryWrapper = new LambdaQueryWrapper();
        lambdaQueryWrapper.like(User::getName, "a")
                .between(User::getAge, 20, 30)
                .isNotNull(User::getEmail);

        //select * from user where name like '%a%' and age >= 20 and age <= 30 and email is not null
        List<User> users = userMapper.selectList(lambdaQueryWrapper);
    }

    @Test
    public void test5(){
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age", 20)
                .like("name", "a") //条件直接调用方法默认使用and 拼接
                .or().isNull("email") //or().第一个条件是or -> 拼接条件还是and
                .isNull("email")
                .set("email", null)
                .set("age", 99);

        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper();
        lambdaUpdateWrapper.gt(User::getAge, 20)
                .like(User::getName, "a")
                .or().isNull(User::getEmail)
                .set(User::getEmail, null)
                .set(User::getAge, 99);

        userMapper.update(null, lambdaUpdateWrapper);
    }
}
