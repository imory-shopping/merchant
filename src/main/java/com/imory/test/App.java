package com.imory.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
//@EnableWebMvc //忽略SpringBoot默认的/static目录，使用src/main/webapp目录作为静态资源目录
public class App extends WebMvcConfigurerAdapter{

    public static void main(String args[])
    {
        SpringApplication.run(App.class,args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        super.addResourceHandlers(registry);
        //registry.addResourceHandler("/**").addResourceLocations("/");
    }
}
