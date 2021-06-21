package com.thread.study.uncaughtexception;

/**
 * @author zzxstart
 * @date 2021/6/21 - 10:19
 */
public class UseOwnUncaughtExceptionHandle implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread.setDefaultUncaughtExceptionHandler(new MyUncaughtExceptionHandle("捕获器1"));
        new Thread(new UseOwnUncaughtExceptionHandle(), "Thread-1").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandle(), "Thread-2").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandle(), "Thread-3").start();
        Thread.sleep(300);
        new Thread(new UseOwnUncaughtExceptionHandle(), "Thread-4").start();
    }

    @Override
    public void run() {
        throw new RuntimeException();
    }
}
