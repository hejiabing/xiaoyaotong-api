package com.xiaoyaotong.api.search.job;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

/**
 * @author ：billHe
 * @description：TODO
 * @date ：2019/12/3 10:32 PM
 */
@Component
public class SchedulerConfig {
    private static Log log = LogFactory.getLog(ESTaskScheduler.class);

    @Autowired
    SchedulerFactoryBean schedulerFactory;
    @Autowired
    private Scheduler scheduler;
    @PostConstruct
    public void init() {
        try {
            JobDetail jobDetail = JobBuilder.newJob(ESJobService.class).withIdentity("job", "xiaoyaotong").build();
            String cron = "0 30 23 * * ?";//每天23点30分执行一次全量同步
            jobDetail.getJobDataMap().put("cron", cron);
            CronTrigger trigger = TriggerBuilder.newTrigger().withIdentity("trigger", "t1").withSchedule(CronScheduleBuilder.cronSchedule(cron)).build();
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
            log.info("初始化成功!");
        } catch (Exception e) {
            log.info("", e);
        }
    }}
