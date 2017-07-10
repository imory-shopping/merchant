package com.imory.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/7
 */
@RequestMapping("/userInfo")
@Controller
public class TdUserInfoController {

    @RequestMapping("/userList")
    //@RequiresPermissions("userInfo:view")//权限管理;
    public String userList()
    {
        return "/userInfo/userList";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userAdd")
    @RequiresPermissions("userInfo:add")//权限管理;
    public String userInfoAdd(){
        return "/userInfo/userInfoAdd";
    }

    /**
     * 用户添加;
     * @return
     */
    @RequestMapping("/userTest")
    @RequiresPermissions("userInfo:test")//权限管理;
    public String userTest(){
        return "/userInfo/userTest";
    }
}
