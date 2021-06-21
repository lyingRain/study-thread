package com.thread.study.uncaughtexception;

/**
 * @author zzxstart
 * @date 2021/6/16 - 15:45
 */

/**
 * 1.不加 try catch 抛出四个异常，都带线程名字
 * 2.加 try catch(只能捕获对应线程内的异常) ，期望捕获到第一个线程的异常，线程234不应该运行，希望看到打印出Caught Exception
 * 3.执行时发现，根本没有Caught Exception.线程234依然运行并且抛出异常
 * 说明线程异常不能用传统方法捕获
 */
public class CanNotCatchDirectly implements Runnable{
    public static void main(String[] args) throws InterruptedException {

        try {
            new Thread(new CanNotCatchDirectly(),"Thread-1").start();
            Thread.sleep(300);
            new Thread(new CanNotCatchDirectly(),"Thread-2").start();
            Thread.sleep(300);
            new Thread(new CanNotCatchDirectly(),"Thread-3").start();
            Thread.sleep(300);
            new Thread(new CanNotCatchDirectly(),"Thread-4").start();
        } catch (Exception e) {
            System.out.println("caught Exception");
        }
       /* Thread.sleep(300);
        new Thread(new CanNotCatchDirectly(),"Thread-2").start();
        Thread.sleep(300);
        new Thread(new CanNotCatchDirectly(),"Thread-3").start();
        Thread.sleep(300);
        new Thread(new CanNotCatchDirectly(),"Thread-4").start();
        */
    }
    @Override
    public void run() {

        try {
            throw new RuntimeException();
        } catch (RuntimeException e) {
            System.out.println("caught Exception");
        }
    }
}
