package com.imory.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/19
 */
@Component
@Order(value = 1)
public class MyRunner1 implements CommandLineRunner{
    @Override
    public void run(String... strings) throws Exception
    {
        System.out.println(">>>>>>>>>>>>>>>服务启动执行，MyRunner1执行加载数据等操作<<<<<<<<<<<<<");
    }
}
