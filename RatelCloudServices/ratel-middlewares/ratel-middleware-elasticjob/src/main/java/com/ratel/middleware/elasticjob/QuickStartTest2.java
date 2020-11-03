package com.ratel.middleware.elasticjob;

import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;

public class QuickStartTest2 {
    public static void main(String args[]) {
        //任务执行间隔时间
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.printf("time: %s,todo ......\n", LocalDateTime.now());
            }
        }, 1000, 2000); //1秒后开始调度，每2秒执行一次
    }
}
