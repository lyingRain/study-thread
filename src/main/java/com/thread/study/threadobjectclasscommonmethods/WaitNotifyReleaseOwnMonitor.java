package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/9 - 11:09
 */

import java.util.concurrent.locks.ReentrantLock;

/**
 * 证明wait只释放当前的那把锁
 */
public class WaitNotifyReleaseOwnMonitor {
    public static volatile Object A = new Object();
    public static volatile Object B = new Object();

    public static void main(String[] args) {
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A) {
                    System.out.println("A got A lock");
                    synchronized (B) {
                        System.out.println("A got B lock");
                        try {
                            A.wait(); 
                            System.out.println("A releasesA lock");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (A) {
                    System.out.println("B got resourceA lock");
                    synchronized (B) {
                        System.out.println("B got resourceB lock");
                    }
                }
            }
        });
        thread1.start();
        thread2.start();
    }
}

