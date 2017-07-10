package com.imory.service;

import com.imory.bean.TdUserInfo;
import com.imory.dao.TdUserInfoRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/7
 */
@Service
public class TdUserInfoServiceImpl implements TdUserInfoService{

    @Resource
    private TdUserInfoRepository tdUserInfoRepository;

    @Override
    public TdUserInfo findByUsername(String username)
    {
        System.out.println("TdUserInfoServiceImpl.findByUsername()");

        return tdUserInfoRepository.findByUsername(username);
    }
}
