package com.thread.study.runthread;

/**
 * @author zzxstart
 * @date 2021/6/3 - 14:51
 */

/**
 * 对比start和run两种启动线程的方式
 */
public class StartAndRunMethod {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            System.out.println(Thread.currentThread().getName());
        };
        //调用主线程
        runnable.run();
        //创建新的线程
        new Thread(runnable).start();
    }

}
