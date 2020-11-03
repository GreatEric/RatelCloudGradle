package com.ratel.middleware.elasticjob;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

public class QuickStartTest4 {
    public static void main(String args[]) {
        //创建Scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();

            //创建JobDetail
            JobBuilder jobDetailBuilder = JobBuilder.newJob(MyJob.class);
            jobDetailBuilder.withIdentity("jobName", "jobGroupName");
            JobDetail jobDetail = jobDetailBuilder.build();

            //创建触发CronTrigger支持日历调度
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triggerName","triggerGroupName")
                    .startNow()
                    .withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?"))
                    .build();

            //创建触发的SimpleTrigger简单的间隔调度
            /*SimpleTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("triggerName","triggerGroupName")
                    .startNow()
                    .withSchedule(SimpleScheduleBuilder
                            .simpleSchedule()
                            .withIntervalInSeconds(2)
                            .repeatForever()
                            .build();
                    );*/
            scheduler.scheduleJob(jobDetail,trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
