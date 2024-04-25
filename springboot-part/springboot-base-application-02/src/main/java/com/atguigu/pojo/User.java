package com.atguigu.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 读取配置的方式1：@Value
 *      直接可以在属性上添加即可
 *      @ Value(key必须写全了)
 *      @ Value只能读取单个值
 *
 * 批量配置读取
 *      @ ConfigurationProperties(prefix = "hck.user") 通用的前缀
 *      实体类
 *          属性名 = 最后一个key的值
 *      优势1：方便 不用一个一个读取
 *      优势2：可以给集合类型赋值
 */
@Component
@Data
@ConfigurationProperties(prefix = "hck.user")
public class User {
//    @Value("${hck.user.username}") //di
    private String username; //等于key

//    @Value("${hck.user.password}")
    private String password;

//    @Value("${hck.user.gfs}")
    private List<String> gfs;
}
