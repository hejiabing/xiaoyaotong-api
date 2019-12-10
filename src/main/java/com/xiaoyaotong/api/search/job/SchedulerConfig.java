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
    private static Log log = LogFactory.getLog(EsTaskScheduler.class);

    @Autowired
    SchedulerFactoryBean schedulerFactory;
    @Autowired
    private Scheduler scheduler;
    @PostConstruct
    public void init() {
        try {
            JobDetail syncAllSpuJob = JobBuilder.newJob(EsSyncAllSpuJob.class).withIdentity("job1", "xiaoyaotong").build();
            String syncAlltSpuJobcron = "0 13 17 * * ?";//每天23点30分执行一次全量同步
            syncAllSpuJob.getJobDataMap().put("syncAlltSpuJobcron", syncAlltSpuJobcron);
            CronTrigger syncAllSpuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "t1").withSchedule(CronScheduleBuilder.cronSchedule(syncAlltSpuJobcron)).build();
            scheduler.scheduleJob(syncAllSpuJob, syncAllSpuTrigger);


            JobDetail syncIncrementSpuJob = JobBuilder.newJob(EsSyncIncrementSpuJob.class).withIdentity("job2", "xiaoyaotong").build();
            String syncIncrementSpuJobCron = "0 */55 * * * ?";//每天23点30分执行一次全量同步
            syncAllSpuJob.getJobDataMap().put("syncIncrementSpuJobCron", syncIncrementSpuJobCron);
            CronTrigger syncIncrementSpuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "t2").withSchedule(CronScheduleBuilder.cronSchedule(syncIncrementSpuJobCron)).build();
            scheduler.scheduleJob(syncIncrementSpuJob, syncIncrementSpuTrigger);



            JobDetail syncAllSkuJob = JobBuilder.newJob(EsSyncAllSkuJob.class).withIdentity("job3", "xiaoyaotong").build();
            String syncAlltSkuJobcron = "0 50 23 * * ?";//每天23点30分执行一次全量同步
            syncAllSkuJob.getJobDataMap().put("syncAlltkpuJobcron", syncAlltSpuJobcron);
            CronTrigger syncAllSkuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "t1").withSchedule(CronScheduleBuilder.cronSchedule(syncAlltSkuJobcron)).build();
            scheduler.scheduleJob(syncAllSkuJob, syncAllSkuTrigger);

            scheduler.start();


            log.info("初始化成功!");
        } catch (Exception e) {
            log.info("", e);
        }
    }}
