package com.thread.study.createthread.wrongways;

/**
 * @author zzxstart
 * @date 2021/6/3 - 10:41
 */

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时器创建线程
 */
public class DemoTimmerTask {
    public static void main(String[] args) {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        },1000,1000);
    }
}
