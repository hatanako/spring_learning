package com.atguigu.mapper;

import com.atguigu.pojo.Schedule;

import java.util.List;

public interface ScheduleMapper {

    List<Schedule> queryAll();

    int delete(int i);
}
