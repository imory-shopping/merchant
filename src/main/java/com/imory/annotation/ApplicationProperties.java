package com.imory.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/19
 */
@Documented //说明该注解将被包含在javadoc中
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) //接口、类、枚举、注解
@Component
public @interface ApplicationProperties {

    String[] locations();

    String prefix() default "";

}
