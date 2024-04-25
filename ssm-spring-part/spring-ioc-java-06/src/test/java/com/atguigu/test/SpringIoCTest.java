package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.config.JavaConfigurationA;
import com.atguigu.ioc_01.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void test(){
        //1.创建ioc容器
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        AnnotationConfigApplicationContext applicationContext1
                = new AnnotationConfigApplicationContext();
        applicationContext1.register(JavaConfiguration.class);
        applicationContext1.refresh();//ioc di
        //2.获取bean
        StudentController bean = applicationContext1.getBean(StudentController.class);

        System.out.println("bean = " + bean);
    }

    @Test
    public void test_04(){
          ApplicationContext applicationContext
                  = new AnnotationConfigApplicationContext(JavaConfigurationA.class);
    }
}
