package com.imory.test.controller;

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
public class HelloController {

    @RequestMapping("/")
    public String hello(){
        return"Hello world!";
    }

    @RequestMapping("/zeroException")
    public int zeroException(){
        System.out.println("111111");
        return 100/0;
    }
}
