package com.ratel.middleware.elasticjob;

import java.time.LocalDateTime;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class QuickStartTest3 {
    public static void main(String args[]) {
        ScheduledExecutorService service = Executors.newScheduledThreadPool(10);
        service.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.printf("time: %s,todo ......\n", LocalDateTime.now());
            }
        },1,2, TimeUnit.SECONDS);
    }
}
