package com.atguigu.statics;

import com.atguigu.Calculator;

public class StaticProxyCalculator implements Calculator {

    private Calculator calculator;

    //使用构造函数传入目标（房东）
    public void setCalculator(Calculator target) {
        this.calculator = target;
    }

    @Override
    public int add(int i, int j) {
        //非核心业务 中介使用
        System.out.println("i = " + i + ", j = " + j);
        //调用目标
        int result = calculator.add(i, j);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int sub(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.sub(i, j);
        System.out.println("result = " + result);
        return 0;
    }

    @Override
    public int mul(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.mul(i, j);
        System.out.println("result = " + result);
        return 0;
    }

    @Override
    public int div(int i, int j) {
        System.out.println("i = " + i + ", j = " + j);
        int result = calculator.div(i, j);
        System.out.println("result = " + result);
        return 0;
    }
}
