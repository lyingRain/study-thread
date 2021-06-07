package com.thread.study.createthread.wrongways;

/**
 * @author zzxstart
 * @date 2021/6/3 - 11:01
 */

/**
 * lamdba表达式创建线程
 */
public class Lambda {
    public static void main(String[] args) {
        new Thread(()-> System.out.println(
                Thread.currentThread().getName()
        )).start();
    }
}
