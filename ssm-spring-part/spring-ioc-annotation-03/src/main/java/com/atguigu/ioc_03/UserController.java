package com.atguigu.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class UserController {

    // <property userService -> 对应类型的bean装配
    // 自动装配注解(DI): 1.ioc容器中查找符合类型的组件对象 2.设置给当前属性(di)
    @Autowired(required = false) //boolean required() default true; 必须有对应类型的组件
               //佛系装配 可以没有 值 = null boolean required() default false;
               //不推荐使用佛系装配，装配的数据后期都会有调用！后面会出现空指针！
    @Qualifier(value = "userServiceImpl")
    private UserService userService;

    @Resource(name = "userServiceImpl")//@Autowired(required = false) + @Qualifier(value = "userServiceImpl")
    private UserService userService1;

    public void show(){
        //嗲用业务层的show方法
        String show = userService.show();
        System.out.println("show = " + show);
    }
}
