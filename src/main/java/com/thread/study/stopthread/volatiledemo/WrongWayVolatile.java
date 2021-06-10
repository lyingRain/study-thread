package com.thread.study.stopthread.volatiledemo;

/**
 * @author zzxstart
 * @date 2021/6/7 - 19:30
 */

/**
 * 用volatile设置boolean标记位
 * 演示用volatile的局限：part1看似可行
 */
public class WrongWayVolatile implements Runnable {
    //变量可见性，多线程之间可以看到（java内存模型）
    public volatile boolean cancle = false;

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !cancle) {
                if (num % 100 == 0) {
                    System.out.println(num + "是一百倍数");
                }
                num++;
                Thread.sleep(1);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        WrongWayVolatile wrongWayVolatile = new WrongWayVolatile();
        Thread thread = new Thread(wrongWayVolatile);
        thread.start();
        Thread.sleep(5000);
        wrongWayVolatile.cancle = true;
    }
}

