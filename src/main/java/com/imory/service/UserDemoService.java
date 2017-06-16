package com.imory.service;

import com.imory.dao.UserDemoDao;
import com.imory.dao.UserDemoRepository;
import com.imory.bean.UserDemo;
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

    @Resource
    private UserDemoDao userDemoDao;

    @Transactional
    public void save(UserDemo userDemo)
    {
        userDemoRepository.save(userDemo);
    }

    public UserDemo getUserById(Integer id)
    {
        return userDemoDao.getUserById(id);
    }

}
