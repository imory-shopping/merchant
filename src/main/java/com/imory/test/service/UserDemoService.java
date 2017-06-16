package com.imory.test.service;

import com.imory.test.bean.UserDemo;
import com.imory.test.dao.UserDemoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/15
 */
@Service
public class UserDemoService {

    @Resource
    private UserDemoRepository userDemoRepository;

    @Transactional
    public void save(UserDemo userDemo)
    {
        userDemoRepository.save(userDemo);
    }

}
