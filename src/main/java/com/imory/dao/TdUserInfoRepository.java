package com.imory.dao;

import com.imory.bean.TdUserInfo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
public interface TdUserInfoRepository extends CrudRepository<TdUserInfo,Long>{

    /**通过username查找用户信息;*/
    //表名跟类名不同需要加上 nativeQuery = true 表示本地查询
    @Query(value = "select * from td_user_info  where username = ?1" ,nativeQuery = true)
    public TdUserInfo findByUsername(String username);
}
