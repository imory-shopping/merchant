package com.imory.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/15
 */
@SpringBootApplication
@EntityScan(basePackages = "com.imory.test.bean")
@EnableJpaRepositories(basePackages={"com.imory.test.dao"})
public class App {

    public static void main(String args[])
    {
        SpringApplication.run(App.class,args);
    }
}
