package com.imory.configuration.bean;

import com.imory.annotation.ApplicationProperties;
import org.springframework.stereotype.Component;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/19
 */
@Component
@ApplicationProperties(locations = "classpath:config/wisely1.properties",prefix = "wisely1")
public class WiselySettings1 {

    private String name;

    private String gender;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getGender()
    {
        return gender;
    }

    public void setGender(String gender)
    {
        this.gender = gender;
    }
}
