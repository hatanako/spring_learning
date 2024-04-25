 package com.atguigu.mapper;

import com.atguigu.pojo.Employee;

public interface EmployeeMapper {

    //根据id查询员工信息
    Employee queryId(Integer id);

    int deleteById(Integer id);
}
