package com.thread.study.createthread.wrongways;

/**
 * @author zzxstart
 * @date 2021/6/3 - 10:55
 */

/**
 * 匿名内部类创建线程
 */
public class AnonymousInnerClassDemo {
    public static void main(String[] args) {
        new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        }.start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());

            }
        }).start();
    }
}
