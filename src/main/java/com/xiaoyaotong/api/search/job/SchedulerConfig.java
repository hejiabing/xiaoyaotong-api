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
            String syncAlltSpuJobcron = "0 30 23 * * ?";//每天23点30分执行一次全量同步
            syncAllSpuJob.getJobDataMap().put("syncAlltSpuJobcron", syncAlltSpuJobcron);
            CronTrigger syncAllSpuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "t1").withSchedule(CronScheduleBuilder.cronSchedule(syncAlltSpuJobcron)).build();
            scheduler.scheduleJob(syncAllSpuJob, syncAllSpuTrigger);


     //   JobDetail syncIncrementSpuJob = JobBuilder.newJob(EsSyncIncrementSpuJob.class).withIdentity("job2", "xiaoyaotong").build();
        //    String syncIncrementSpuJobCron = "0 */10 * * * ?";//每10分钟执行一次增量同步
            /*       syncAllSpuJob.getJobDataMap().put("syncIncrementSpuJobCron", syncIncrementSpuJobCron);
            CronTrigger syncIncrementSpuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "t2").withSchedule(CronScheduleBuilder.cronSchedule(syncIncrementSpuJobCron)).build();
            scheduler.scheduleJob(syncIncrementSpuJob, syncIncrementSpuTrigger);
            */



            JobDetail syncAllSkuJob = JobBuilder.newJob(EsSyncAllSkuJob.class).withIdentity("job3", "xiaoyaotong").build();
            String syncAllSkuJobcron = "0 39 21 * * ?";//每天22点30分执行一次全量同步
            syncAllSkuJob.getJobDataMap().put("syncAllSkuJobcron", syncAllSkuJobcron);
            CronTrigger syncAllSkuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "t3").withSchedule(CronScheduleBuilder.cronSchedule(syncAllSkuJobcron)).build();
            scheduler.scheduleJob(syncAllSkuJob, syncAllSkuTrigger);


            JobDetail syncAllCompanyItemJob = JobBuilder.newJob(EsSyncAllCompanyItemJob.class).withIdentity("job4", "xiaoyaotong").build();
            String syncAllCompanyItemJobcron = "0 35 14 * * ?";//每天23点30分执行一次全量同步
            syncAllCompanyItemJob.getJobDataMap().put("syncAllCompanyItemJobcron", syncAllCompanyItemJobcron);
            CronTrigger syncAllCompanyItemJobTrigger = TriggerBuilder.newTrigger().withIdentity("trigger4", "t4").withSchedule(CronScheduleBuilder.cronSchedule(syncAllCompanyItemJobcron)).build();
            scheduler.scheduleJob(syncAllCompanyItemJob, syncAllCompanyItemJobTrigger);




            scheduler.start();


            log.info("初始化成功!");
        } catch (Exception e) {
            log.info("", e);
        }
    }}
