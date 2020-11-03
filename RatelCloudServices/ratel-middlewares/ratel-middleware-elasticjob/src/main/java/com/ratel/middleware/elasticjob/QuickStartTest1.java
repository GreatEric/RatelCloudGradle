package com.ratel.middleware.elasticjob;

import java.time.LocalDateTime;

public class QuickStartTest1 {
    public static void main(String args[]){
        //任务执行间隔时间
        final long timeInterval = 1000;
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while(true){
                    System.out.printf("time: %s,todo ......\n", LocalDateTime.now());
                    try{
                        Thread.sleep(timeInterval);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }
}
