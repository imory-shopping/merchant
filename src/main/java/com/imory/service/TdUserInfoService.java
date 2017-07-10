package com.imory.service;

import com.imory.bean.TdUserInfo;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/7
 */
public interface TdUserInfoService {

    public TdUserInfo findByUsername(String username);
}
