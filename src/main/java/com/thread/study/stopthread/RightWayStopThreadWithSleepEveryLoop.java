package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/4 - 16:42
 */

/**
 * 如果在执行过程中，每次循环都会调用sleep/wait方法，那么每次迭代不需要检测是否已经中断，sleep过程中会有响应中断
 */
public class RightWayStopThreadWithSleepEveryLoop {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            int num = 0;
            while (num <= 10000 ) {
                if (num % 100 == 0) {
                    System.out.println(num + "是倍数");
                }
                num++;
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(9000);
        thread.interrupt();
    }
}
