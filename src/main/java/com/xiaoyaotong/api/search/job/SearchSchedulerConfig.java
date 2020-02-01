package com.xiaoyaotong.api.search.job;

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
public class SearchSchedulerConfig {
    private static Log log = LogFactory.getLog(TaskSchedulerService.class);

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
        //全量同步spu,每天晚上11点30分
        taskSchedulerService.addJob("syncAllSpuJob","group1","trigger1","t1",EsSyncAllSpuJob.class,"0 45 23 * * ?");
        //增量同步spu,每7分钟一次
        taskSchedulerService.addJob("syncIncrementSpuJob","group2","trigger2","t2",EsSyncIncrementSpuJob.class,"0 */2 * * * ?");
        //全量同步sku，每天晚上2点
        taskSchedulerService.addJob("syncAllSkuJob","group3","trigger3","t3",EsSyncAllSkuJob.class,"0 57 23 * * ?");
        //增量同步sku,每5分钟一次
        taskSchedulerService.addJob("syncIncrementSkuJob","group4","trigger4","t4", EsSyncIncrementSkuJob.class,"0 */2 * * * ?");
        //全量同步公司自己的sku
        taskSchedulerService.addJob("syncAllCompanyItemJob","group5","trigger5","t5",EsSyncAllCompanyItemJob.class,"00 50 23 * * ?");
        //增量同步公司自己的sku,每3分钟一次
        taskSchedulerService.addJob("EsSyncIncrementCompanyItemJob","group6","trigger6","t6",EsSyncIncrementCompanyItemJob.class,"0 */2 * * * ?");

    }

    /*
    public void inited() {
        try {
            JobDetail syncAllSpuJob = JobBuilder.newJob(EsSyncAllSpuJob.class).withIdentity("job1", "xiaoyaotong").build();
            String syncAlltSpuJobcron = "0 30 23 * * ?";//每天23点30分执行一次全量同步
            syncAllSpuJob.getJobDataMap().put("syncAlltSpuJobcron", syncAlltSpuJobcron);
            CronTrigger syncAllSpuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1", "t1").withSchedule(CronScheduleBuilder.cronSchedule(syncAlltSpuJobcron)).build();
            scheduler.scheduleJob(syncAllSpuJob, syncAllSpuTrigger);

        JobDetail syncIncrementSpuJob = JobBuilder.newJob(EsSyncIncrementSpuJob.class).withIdentity("job2", "xiaoyaotong").build();
            String syncIncrementSpuJobCron = "0 0/5 * * * ?";//每10分钟执行一次增量同步
                   syncAllSpuJob.getJobDataMap().put("syncIncrementSpuJobCron", syncIncrementSpuJobCron);
            CronTrigger syncIncrementSpuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger2", "t2").withSchedule(CronScheduleBuilder.cronSchedule(syncIncrementSpuJobCron)).build();
            scheduler.scheduleJob(syncIncrementSpuJob, syncIncrementSpuTrigger);


            JobDetail syncAllSkuJob = JobBuilder.newJob(EsSyncAllSkuJob.class).withIdentity("job3", "xiaoyaotong").build();
            String syncAllSkuJobcron = "0 50 17 * * ?";//每天22点30分执行一次全量同步
            syncAllSkuJob.getJobDataMap().put("syncAllSkuJobcron", syncAllSkuJobcron);
            CronTrigger syncAllSkuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger3", "t3").withSchedule(CronScheduleBuilder.cronSchedule(syncAllSkuJobcron)).build();
            scheduler.scheduleJob(syncAllSkuJob, syncAllSkuTrigger);

            JobDetail syncChangedSkuJob = JobBuilder.newJob(EsSyncIncrementSkuJob.class).withIdentity("job13", "xiaoyaotong").build();
            String synChangedSkuJobcron = "0 0/3 * * * ?";//每天22点30分执行一次全量同步
            syncChangedSkuJob.getJobDataMap().put("synChangedSkuJobcron", synChangedSkuJobcron);
            CronTrigger syncChangedSkuTrigger = TriggerBuilder.newTrigger().withIdentity("trigger13", "t3").withSchedule(CronScheduleBuilder.cronSchedule(synChangedSkuJobcron)).build();
            scheduler.scheduleJob(syncChangedSkuJob, syncChangedSkuTrigger);

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
    }

    */

}
