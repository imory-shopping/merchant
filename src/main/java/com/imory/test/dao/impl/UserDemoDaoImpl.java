package com.imory.test.dao.impl;

import com.imory.test.bean.UserDemo;
import com.imory.test.dao.UserDemoDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/16
 */
@Repository
public class UserDemoDaoImpl implements UserDemoDao{

    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public UserDemo getUserById(Integer id)
    {
        System.out.println("id:" + id);
        String sql = "select * from user_demo where id = ?";
        RowMapper<UserDemo> rowMapper = new BeanPropertyRowMapper(UserDemo.class);
        return jdbcTemplate.queryForObject(sql, rowMapper, id);
    }
}
