package com.noscan.service;

import org.springframework.stereotype.Service;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/5
 */
@Service
public class HelloService {
    /**
     * 启动的时候观察控制台是否打印此信息;
     */

    public HelloService()
    {

        System.out.println("HelloService.HelloService()");

        System.out.println("com.noscan.service.HelloService.HelloService()");

        System.out.println("HelloService.HelloService()");

    }
}
