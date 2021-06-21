package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/15 - 10:25
 */

/**
 * 两个线程交替打印1-100的奇数偶数，用wait/notify
 */
public class WaitNotifyPrintOddEveWait {
    private static int count;
    public static final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        new Thread(new TurningRunner(),"偶数").start();
        Thread.sleep(1);
        new Thread(new TurningRunner(),"奇数").start();
    }
    //1.一旦拿到锁就打印，不用判断是否奇数偶数，打印完唤醒其他线程，自己休眠
    static class TurningRunner implements Runnable{

        @Override
        public void run() {
            while (count<=100){
                synchronized (lock){
                    System.out.println(Thread.currentThread().getName()+":"+count++);
                    lock.notify();
                    if (count<=100){
                        try {
                            //如果任务没有结束，让出锁并且自己休眠
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
