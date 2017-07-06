package com.imory.service;

import com.imory.bean.DemoInfo;
import com.imory.dao.DemoInfoRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
@Service
public class DemoInfoServiceImpl implements DemoInfoService{

    @Resource
    private DemoInfoRepository demoInfoRepository;

    @Resource
    private RedisTemplate<String,String> redisTemplate;

    //keyGenerator="myKeyGenerator"
    @Cacheable(value="demoInfo") //缓存,这里没有指定key.
    @Override
    public DemoInfo findById(long id)
    {
        System.err.println("DemoInfoServiceImpl.findById()=========从数据库中进行获取的....id=" + id);
        return demoInfoRepository.findOne(id);
    }

    @Cacheable(value = "demoInfo",key = "'getDemoInfoByIds' + #id",condition = "#id < 2")
    @Override
    public DemoInfo getDemoInfoById(long id)
    {
        System.err.println("DemoInfoServiceImpl.getDemoInfoById()=========从数据库中进行获取的....id=" + id);
        return demoInfoRepository.findOne(id);
    }

    @CacheEvict(value="demoInfo")
    @Override
    public void deleteFromCache(long id)
    {
        System.out.println("DemoInfoServiceImpl.delete().从缓存中删除.");
    }

    @Override
    public void test()
    {
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();

        valueOperations.set("mykey4", "random1="+Math.random());

        System.out.println(valueOperations.get("mykey4"));
    }

    @Cacheable(value = "demo", key = "'findByIdEhcache' + #id")
    @Override
    public DemoInfo findByIdEhcache(long id)
    {
        return demoInfoRepository.findOne(id);
    }

}
