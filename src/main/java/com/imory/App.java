package com.imory;

import com.imory.servlet.MyServlet1;
import com.imory.util.SpringUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

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
@EntityScan(basePackages = "com.imory.bean")
@EnableJpaRepositories(basePackages={"com.imory.dao"})
//@EnableWebMvc //忽略SpringBoot默认的/static目录，使用src/main/webapp目录作为静态资源目录
@ServletComponentScan //扫描到我们自己编写的servlet和filter
//@Import(value = {SpringUtil.class}) //方式3
public class App extends WebMvcConfigurerAdapter{

    public static void main(String args[])
    {
        SpringApplication.run(App.class,args);
    }

    //@Bean //方式2
    public SpringUtil springUtil2()
    {
        return new SpringUtil();
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry)
    {
        super.addResourceHandlers(registry);
        //registry.addResourceHandler("/**").addResourceLocations("/");
    }

    @Bean
    public ServletRegistrationBean myServlet1()
    {
        return new ServletRegistrationBean(new MyServlet1(),"/myServlet1/*");
    }
}
