package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/9 - 10:46
 */

import lombok.SneakyThrows;

/**
 * 3个线程
 * 线程1和线程2首先被阻塞，线程3唤醒他们。notify   notifyALl
 * start先执行不代表线程先启动
 */
public class WaitNotifyAll implements Runnable {
    public static final Object object = new Object();

    @SneakyThrows
    public static void main(String[] args) {
        WaitNotifyAll r = new WaitNotifyAll();
        Thread thread1 = new Thread(r);
        Thread thread2 = new Thread(r);
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object){
                    object.notifyAll();
                   // object.notify();
                    System.out.println("Thread3 notified");
                }
            }
        });
        thread1.start();
        thread2.start();
        //保证执行顺序
        Thread.sleep(200);
        thread3.start();
    }
    @Override
    public void run() {
synchronized (object){
    System.out.println(Thread.currentThread().getName()+"got object lock.");
    try {
        System.out.println(Thread.currentThread().getName()+"wait to start.");
        object.wait();
        System.out.println(Thread.currentThread().getName()+"waiting is end");
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
    }
}
