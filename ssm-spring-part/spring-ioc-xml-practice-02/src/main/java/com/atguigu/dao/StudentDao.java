package com.atguigu.dao;

import com.atguigu.pojo.Student;

import java.util.List;

public interface StudentDao {
    /**
     * 数据库查询全部学生数据
     * @return
     */
    List<Student> queryAll();
}
