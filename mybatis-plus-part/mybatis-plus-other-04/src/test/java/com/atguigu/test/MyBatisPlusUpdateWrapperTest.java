package com.atguigu.test;

import com.atguigu.mapper.UserMapper;
import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyBatisPlusUpdateWrapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void test4(){
        //将年龄大于20并且用户名中包含a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE name LIKE ? AND age> ? OR email IS NULL

        //QueryWrapper修改 [条件]
        //1.准备要修改的实体类对象
        //2.不能改为null

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age", 20)
                .like("name", "a") //条件直接调用方法默认使用and 拼接
                .or().isNull("email") //or().第一个条件是or -> 拼接条件还是and
                .isNull("email");

        //要修改的数据
        User user = new User();
        user.setAge(88);
        user.setEmail("hehehe");
        userMapper.update(user, queryWrapper);
    }

    @Test
    public void test5(){
        //将年龄大于20并且用户名中包含a或邮箱为null的用户信息修改
        //UPDATE t_user SET age=?, email=? WHERE name LIKE ? AND age> ? OR email IS NULL

        //QueryWrapper修改 [条件]
        //1.准备要修改的实体类对象
        //2.不能改为null

        //UpdateWrapper修改[条件，修改]
        //1.直接携带修改数据 set("列名","值")
        //2.指定任意修改值 set("列名",null)

        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.gt("age", 20)
                .like("name", "a") //条件直接调用方法默认使用and 拼接
                .or().isNull("email") //or().第一个条件是or -> 拼接条件还是and
                .isNull("email")
                        .set("email", null)
                            .set("age", 99);

        userMapper.update(null, updateWrapper);
    }

}
