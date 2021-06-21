package com.thread.study.uncaughtexception;

/**
 * @author zzxstart
 * @date 2021/6/16 - 15:36
 */

/**
 * 单线程，抛出，处理，有异常堆栈
 * 多线程，子线程发生异常，会有何不同
 */
public class ExceptionInChildThread implements Runnable{
    public static void main(String[] args) {
        //子线程抛出错误，不影响主线程运行
        new Thread(new ExceptionInChildThread()).start();
        for (int i = 0; i <1000 ; i++) {
            System.out.println(i);
        }
    }
    @Override
    public void run() {
        throw new RuntimeException();
    }
}
