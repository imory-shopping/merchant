package com.imory.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *   监听Session的创建与销毁
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/19
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener{
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent)
    {
        System.out.println("Session 创建");
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)
    {
        System.out.println("Session 销毁");
    }
}
