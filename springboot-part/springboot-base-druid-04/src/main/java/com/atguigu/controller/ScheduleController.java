package com.atguigu.controller;

import com.atguigu.pojo.Schedule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("schedule")
public class ScheduleController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("list")
    public List<Schedule> list(){
        //数据库
        String sql = "select * from schedule";
        List<Schedule> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Schedule.class));
        return list;
    }
}
