package com.thread.study.createthread;

/**
 * @author zzxstart
 * @date 2021/6/1 - 15:33
 */

/**
 * 用Runable方式创建线程
 */
public class ThreadTest1 implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new ThreadTest1(),"方式一");
        thread.start();
    }

    @Override
    public void run() {
        System.out.println("成功");
    }
}
