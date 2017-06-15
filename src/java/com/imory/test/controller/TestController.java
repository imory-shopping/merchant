package com.imory.test.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/15
 */
@RestController
@SpringBootApplication
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
