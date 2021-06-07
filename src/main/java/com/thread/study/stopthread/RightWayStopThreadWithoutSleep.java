package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/3 - 16:55
 */

/**
 * run方法内没有sleep或wait方法时，停止线程
 */
public class RightWayStopThreadWithoutSleep implements Runnable {

    public static void main(String[] args) {
        Thread thread = new Thread(new RightWayStopThreadWithoutSleep());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Override
    public void run() {
        int num = 0;
        while (!Thread.currentThread().isInterrupted() &&num <= Integer.MAX_VALUE/2){
            if (num % 10000 == 0){
                System.out.println(num+"是倍数");
            }
            num++;
        }
        System.out.println("任务结束"+num);
    }
}
