package com.imory.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/7/5
 */
@Configuration
// classpath路径：locations={"classpath:application-bean1.xml","classpath:application-bean2.xml"}
//file路径： locations ={"file:d:/test/application-bean1.xml"};
@ImportResource(locations = "classpath:application-bean.xml")
public class XmlConfig {
}
