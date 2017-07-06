package com.imory.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/6
 */
@Entity
//如果不实现Serializable 则redis序列化会报错
public class DemoInfo implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    private String name;

    private String pwd;

    public long getId()
    {

        return id;

    }

    public void setId(long id)
    {

        this.id = id;

    }

    public String getName()
    {

        return name;

    }

    public void setName(String name)
    {

        this.name = name;

    }

    public String getPwd()
    {

        return pwd;

    }

    public void setPwd(String pwd)
    {

        this.pwd = pwd;

    }


    @Override

    public String toString()
    {

        return "DemoInfo [id=" + id + ",name=" + name + ", pwd=" + pwd + "]";

    }


}
