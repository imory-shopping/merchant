package com.imory.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * <p>名称</p>
 * <p/>
 * <p>wikiURL</p>
 *
 * @author zb.jiang
 * @version 1.0
 * @Date 2017/6/16
 */
@Configuration
@EnableScheduling //声明定时器
public class SchedulingConfig {

    //@Scheduled(fixedRate=10000) // 每10秒执行一次
    @Scheduled(cron = "0/10 * * * * ?") // 每10秒执行一次
    public void scheduler() {
        //System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
    }
}
