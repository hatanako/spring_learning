package com.atguigu.service;

import com.atguigu.mapper.ScheduleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ScheduleService {

    @Autowired
    private ScheduleMapper scheduleMapper;

    @Transactional
    public void delete(){
        int rows = scheduleMapper.delete(1);
        System.out.println("rows = " + rows);
//        int i = 1/0;
    }
}
