package com.atguigu.test;

import com.atguigu.config.JavaConfiguration;
import com.atguigu.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringIoCTest {

    @Test
    public void test(){
        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(JavaConfiguration.class);

        StudentController controller = applicationContext.getBean(StudentController.class);

        controller.findAll();
    }
}
