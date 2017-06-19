package com.imory.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/19
 */
@Controller
public class JspController {

    @RequestMapping("/hello/jsp")
    public String hello()
    {
        return "hello";
    }
}
