package com.imory.configuration;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
//@Configuration
//@EnableCaching //启动缓存
public class EhCacheConfig {

    /**
     *  ehcache主要的管理器
     * @param bean
     * @return
     */
    @Bean
    public EhCacheCacheManager ehCacheCacheManager(EhCacheManagerFactoryBean bean)
    {
        System.out.println("EhCacheCacheManager.ehCacheCacheManager()");
        return new EhCacheCacheManager(bean.getObject());
    }

    /**
      * 据shared与否的设置,
      * Spring分别通过CacheManager.create()
      * 或new CacheManager()方式来创建一个ehcache基地.
      *
      * 也说是说通过这个来设置cache的基地是这里的Spring独用,还是跟别的(如hibernate的Ehcache共享)
      *
      */
    @Bean
    public EhCacheManagerFactoryBean ehCacheManagerFactoryBean()
    {
        System.out.println("EhCacheManagerFactoryBean.ehCacheManagerFactoryBean()");
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("config/ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(Boolean.TRUE);
        return ehCacheManagerFactoryBean;
    }
}
