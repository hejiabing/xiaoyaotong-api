package com.xiaoyaotong.api.util;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;
import org.quartz.*;

/**
 * @author ：billHe
 * @description：一个简单的job调度，用于数据同步
 * @date ：2019/12/3 10:25 PM
 */
@Service
public class TaskSchedulerService {

    private static Log log = LogFactory.getLog(TaskSchedulerService.class);

    @Autowired
    SchedulerFactoryBean schedulerFactory;

    @Autowired
    private Scheduler scheduler;

    /**
     * 添加一个定时任务
     *
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param jobClass         任务
     * @param cron             时间设置，参考quartz说明文档
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName, Class jobClass, String cron) {
        try {
            scheduler = schedulerFactory.getScheduler();
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            scheduler.scheduleJob(jobDetail, trigger);
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            log.info("添加任务出现异常！,{}", e);
        }
    }

    /**
     * 修改一个任务的触发时间
     *
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     * @param cron             时间设置，参考quartz说明文档
     */
    public void modifyJobTime(String triggerName, String triggerGroupName, String cron) {
        try {
            scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            CronTrigger trigger = (CronTrigger) scheduler.getTrigger(triggerKey);
            if (trigger == null) {
                return;
            }
            String oldTime = trigger.getCronExpression();
            if (!oldTime.equalsIgnoreCase(cron)) {
                //方式一 ：调用 rescheduleJob 开始
                TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
                triggerBuilder.withIdentity(triggerName, triggerGroupName);
                triggerBuilder.startNow();
                triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cron));
                trigger = (CronTrigger) triggerBuilder.build();
                // 方式一 ：修改一个任务的触发时间
                scheduler.rescheduleJob(triggerKey, trigger);
            }
        } catch (Exception e) {
            log.info("修改任务出现异常！,{}", e);
        }
    }

    /**
     * 移除一个任务
     *
     * @param jobName          任务名
     * @param jobGroupName     任务组名
     * @param triggerName      触发器名
     * @param triggerGroupName 触发器组名
     */
    public void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) {
        try {
            scheduler = schedulerFactory.getScheduler();
            TriggerKey triggerKey = TriggerKey.triggerKey(triggerName, triggerGroupName);
            scheduler.pauseTrigger(triggerKey);
            scheduler.unscheduleJob(triggerKey);
            scheduler.deleteJob(JobKey.jobKey(jobName, jobGroupName));
        } catch (Exception e) {
            log.info("移除任务出现异常！,{}", e);
        }
    }
}
