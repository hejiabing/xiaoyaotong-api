package com.xiaoyaotong.api.skumatch.job;

import com.xiaoyaotong.api.util.TaskSchedulerService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/3 10:32 PM
 */
@Service
public class MatchSchedulerConfig {
    private static Log log = LogFactory.getLog(MatchSchedulerConfig.class);

    /*
    @Autowired
    SchedulerFactoryBean schedulerFactory;
    @Autowired
    private Scheduler scheduler;
    */
    @Autowired
    TaskSchedulerService taskSchedulerService;

    @PostConstruct
    public void init(){
        //EsTaskScheduler taskScheduler = new EsTaskScheduler();
        //String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron
        //匹配sku的job
        taskSchedulerService.addJob("skuMatchJob","group100","trigger100","t100",SkuMatchJob.class,"0 */2 * * * ?");
        }
}
