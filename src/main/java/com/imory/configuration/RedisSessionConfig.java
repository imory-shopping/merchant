package com.imory.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
@Configuration
//@EnableRedisHttpSession来开启spring session支持
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds= 60) //1分钟失效
@EnableRedisHttpSession
public class RedisSessionConfig {
}
