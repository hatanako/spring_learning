package com.atguigu.mapper;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

import com.atguigu.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
* @author 11303
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-01-23 23:05:48
* @Entity com.atguigu.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    //方法

    //批量插入
    int insertBatch(@Param("userCollection") Collection<User> userCollection);

    //查询
    List<User> selectByNameAndAgeOrderById(@Param("name") String name, @Param("age") Integer age);
}




