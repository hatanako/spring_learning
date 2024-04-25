package com.atguigu.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

/**
 * 业务层配置类：service, aop, tx
 *
 * 1.service
 * 2.开启aop注解的支持 aspect :@Before @After @AfterReturning @AfterThrowing @Around @Aspect @Order
 * 3.tx声明式事务管理：1.对应的事务管理器实现[TransactionManager DataSource.. Hibernate.. Jpa..]2.骄傲u去事务注解支持
 */
@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@ComponentScan("com.atguigu.service")
public class  ServiceJavaConfig {

    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;
    }
}
