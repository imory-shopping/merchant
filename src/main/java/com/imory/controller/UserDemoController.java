package com.imory.controller;

import com.imory.bean.UserDemo;
import com.imory.service.UserDemoService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
public class UserDemoController {

    @Resource
    private UserDemoService userDemoService;

    @RequestMapping("/getUserBean")
    public UserDemo getUserBean()
    {
        UserDemo userDemo = new UserDemo();
        userDemo.setUserName("测试用户");
        return userDemo;
    }

    @RequestMapping("/saveUser")
    public String saveUser()
    {
        UserDemo userDemo = new UserDemo();
        userDemo.setUserName("测试用户2");
        userDemoService.save(userDemo);
        return "ok.UserDemoController.save";
    }

    @RequestMapping("/get/{id}")
    public UserDemo getUser(@PathVariable("id") Integer id)
    {
        return userDemoService.getUserById(id);
    }

    @RequestMapping("/get")
    public UserDemo getUserById(Integer id)
    {
        return userDemoService.getUserById(id);
    }
}
