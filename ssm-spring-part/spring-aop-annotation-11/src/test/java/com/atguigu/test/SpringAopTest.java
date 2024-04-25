package com.atguigu.test;

import com.atguigu.service.impl.CalculatorPureImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:spring.xml")
public class SpringAopTest {

    @Autowired
    private CalculatorPureImpl calculator;

    @Test
    public void test(){
        int add = calculator.add(1, 1);
        System.out.println("add = " + add);
    }
}
