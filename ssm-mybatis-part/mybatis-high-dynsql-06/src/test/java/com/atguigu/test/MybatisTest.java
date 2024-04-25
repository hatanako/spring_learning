package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MybatisTest {
    private SqlSession session;

    @BeforeEach //每次走测试方法之前 先走的初始化方法
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession(true);
    }

    //测试if where标签
    @Test
    public void test_01(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Employee> list = mapper.query(null, 101.0);
        System.out.println("list = " + list);
    }


    @AfterEach //每次测试方法之后调用的方法
    public void clean() {
        session.close();
    }
}
