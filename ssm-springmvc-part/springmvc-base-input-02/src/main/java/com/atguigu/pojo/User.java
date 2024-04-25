package com.atguigu.pojo;

import lombok.Data;

@Data
public class User {
    private String name;//属性必须等于参数名
    private int age = 18;
}
