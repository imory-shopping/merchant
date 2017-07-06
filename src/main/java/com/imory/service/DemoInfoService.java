package com.imory.service;

import com.imory.bean.DemoInfo;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
public interface DemoInfoService {
    public DemoInfo findById(long id);

    public DemoInfo getDemoInfoById(long id);

    public DemoInfo findByIdEhcache(long id);

    public void deleteFromCache(long id);

    void test();
}
