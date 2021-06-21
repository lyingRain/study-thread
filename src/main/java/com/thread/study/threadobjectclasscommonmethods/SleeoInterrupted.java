package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/15 - 16:00
 */

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * 每隔一秒钟输出当前时间，别中断 观察
 * Thread.sleep()
 * TimeUtil.SECONDS.sleep()   更好/ 如果传参小于0  直接忽略
 */
public class SleeoInterrupted implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SleeoInterrupted());
        thread.start();
        System.out.println(3);
        Thread.sleep(1000);
        System.out.println(4);
        thread.interrupt();
    }
    @Override
    public void run() {
        for (int i = 0; i <10 ; i++) {
            System.out.println(new Date());
            try {
                System.out.println(1);
                TimeUnit.SECONDS.sleep(1);
                System.out.println(2);
            } catch (InterruptedException e) {
                System.out.println("我被中断了");
                e.printStackTrace();
            }
        }
    }
}
