package com.imory.test.dao;

import com.imory.test.bean.UserDemo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/15
 */
@Repository
public interface UserDemoRepository extends CrudRepository<UserDemo,Long>{
}
