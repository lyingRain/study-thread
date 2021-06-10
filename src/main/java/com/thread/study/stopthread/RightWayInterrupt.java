package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/7 - 21:40
 */

/**
 * 注意Thread.interrupted()方法的目标对象是“当前线程”，而不管方法来自哪个地方
 */
public class RightWayInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                //无限循环
                for (; ; ) {

                }
            }
        });
        //启动线程
        thread.start();
        //设置中断标志
        thread.interrupt();
        //获取中断标志
        System.out.println("isInterrupt:" + thread.isInterrupted()+" "+thread.getName());
        //获取中断标志并重置,当前调用它的线程,静态方法main函数
        System.out.println("interrupted:" + thread.interrupted()+Thread.currentThread().getName());
        //获取中断标志并重置
        System.out.println("interrupted:" + Thread.interrupted());
        //获取中断标志
        System.out.println("isInterrupt:" + thread.isInterrupted());
        thread.join();
        System.out.println("Main thread is over");
    }
}
