package com.atguigu.json;

import com.atguigu.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RequestMapping("json")
@Controller
@ResponseBody
public class JsonController {

    // data -> 请求体 post {name, age, gender}
    // 前端 -> json -> 415 不支持数据类型？？
    // 原有：Java原生的api，只支持路径参数和param参数 request.getParameter("key);param 不支持json
    //      json就是前端的格式
    // 解决：1.导入json处理的依赖 2.handlerAdapter配置json转化器
    @PostMapping("data")
    public String data(@RequestBody Person person){
        System.out.println("person = " + person);
        return person.toString();
    }
}
