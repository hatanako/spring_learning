package com.atguigu.test;

import com.atguigu.mapper.EmployeeMapper;
import com.atguigu.pojo.Employee;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class MaBatisTest {
    private SqlSession session;

    @BeforeEach //每次走测试方法之前 先走的初始化方法
    public void init() throws IOException {
        session = new SqlSessionFactoryBuilder()
                .build(Resources.getResourceAsStream("mybatis-config.xml"))
                .openSession(true);
    }

    //使用分页插件
    @Test
    public void test_01(){
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        //调用之前，先设置分页数据(当前是第几页，每页显示多少个！)
        PageHelper.startPage(1, 2);//1, 2
        //TODO：注意不能将两条查询装到一个分页区
        List<Employee> list = mapper.queryList();
        //将查询数据封装到一个PageInfo的分页实体类(一共有多少页，一共有多少条等等)
        PageInfo<Employee> pageInfo = new PageInfo<>(list);

        //pageInfo获取分页的数据
        //当前页的数据
        List<Employee> list1 = pageInfo.getList();
        System.out.println("list1 = " + list1);
        //获取总页数
        int pages = pageInfo.getPages();
        System.out.println("pages = " + pages);
        //获取总条数
        long total = pageInfo.getTotal();
        System.out.println("total = " + total);

        int pageNum = pageInfo.getPageNum();
        System.out.println("pageNum = " + pageNum);
        int pageSize = pageInfo.getPageSize();
        System.out.println("pageSize = " + pageSize);
        //...
    }


    @AfterEach //每次测试方法之后调用的方法
    public void clean() {
        session.close();
    }
}
