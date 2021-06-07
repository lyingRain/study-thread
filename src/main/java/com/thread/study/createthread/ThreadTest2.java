package com.thread.study.createthread;

/**
 * @author zzxstart
 * @date 2021/6/1 - 17:21
 */

/**
 * 用Thread创建线程
 */
public class ThreadTest2 extends Thread{
    @Override
    public void run() {
        System.out.println("成功");
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest2(), "方式二");
        thread.start();
    }
}
