package com.thread.study.sixstatus;

/**
 * @author zzxstart
 * @date 2021/6/8 - 14:56
 */

/**
 * 展示Bolcked,Waiting  TimedWaiting
 */
public class BlockedWaitingTimedWaiting implements Runnable{
    public static void main(String[] args) {
        BlockedWaitingTimedWaiting runnable = new BlockedWaitingTimedWaiting();
        Thread thread1 = new Thread(runnable);
        thread1.start();
        Thread thread2 = new Thread(runnable);
        thread2.start();
        //打印出Time_waiting状态，因为正在执行Thread.sleep(1000)
        System.out.println(thread1.getState());
        //打印Blocked状态，因为thread2想拿到sync()的锁却拿不到
        System.out.println(thread2.getState());
        try {
            Thread.sleep(1300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //打印waiting状态
        System.out.println(thread1.getState());
    }
    @Override
    public void run() {
        syn();
    }
    public synchronized void syn(){
        try {
            Thread.sleep(1000);
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
