package com.imory.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/15
 */
//@RestController //返回json字符串的数据，直接可以编写RESTFul的接口；
//@SpringBootApplication //申明让spring boot自动给程序进行必要的配置，等价于以默认属性使用@Configuration，@EnableAutoConfiguration和@ComponentScan
public class TestController {

    @RequestMapping("/")
    public String helloWorld()
    {
        return "Hello world!";
    }

    public static void main(String args[])
    {
        SpringApplication.run(TestController.class,args);
    }
}
