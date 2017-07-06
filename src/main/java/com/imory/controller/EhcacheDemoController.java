package com.imory.controller;

import com.imory.service.DemoInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
@Controller
@RequestMapping("/ehcache")
public class EhcacheDemoController {

    @Autowired
    private DemoInfoService demoInfoService;

    @RequestMapping("/get")
    public @ResponseBody
    String getDemoInfoById(long id)
    {
        demoInfoService.findByIdEhcache(id);
        return "ok";
    }
}
