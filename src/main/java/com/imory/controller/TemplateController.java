package com.imory.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/16
 */
@Controller
public class TemplateController {

    @Value("${spring.thymeleaf.cache}")
    private Boolean cacheFlag;

    /**
     * 返回html模板.
     */
    @RequestMapping("/helloHtml")
    public String helloHtml(Map<String,Object> map){
        System.out.println("============TemplateController=============");
        System.out.println("cacheFlag:" + cacheFlag);
        System.out.println("============TemplateController=============");
        map.put("hello","fromTemplateController.helloHtml");
        return "/helloHtml";
    }
}
