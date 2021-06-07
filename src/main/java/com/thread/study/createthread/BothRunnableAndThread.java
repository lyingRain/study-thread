package com.thread.study.createthread;

/**
 * @author zzxstart
 * @date 2021/6/2 - 14:59
 */

/**
 * 同时使用两种实现线程的方式
 */
public class BothRunnableAndThread {
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Runnable");
            }
        }) {
            @Override
            public void run() {
                System.out.println("Thread");
            }
        }.start();
    }
}
