package com.imory.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 * 使用@WebListener注解，实现ServletContextListener接口
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/19
 */
@WebListener
public class MyServletContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent)
    {
        System.out.println("MyServletContextListener初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent)
    {
        System.out.println("MyServletContextListener销毁");
    }
}
