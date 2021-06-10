package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/7 - 19:00
 */

/**
 * 错误的停止线程   使用stop方法，回导致线程运行中突然停止，没办法完成一个基本单位的操作，造成脏数据,强制停止。本质不安全
 */
public class StopThread implements Runnable {
    //模拟指挥部队：一共有5个连队，以连为单位发放武器,一个连十个人
    @Override
    public void run() {
            for (int i = 0; i < 5; i++) {
                    System.out.println("连队" + i + "领取武器");
                    for (int j = 0; j < 10; j++) {
                        if (!Thread.currentThread().isInterrupted()) {
                            System.out.println(j);
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                //Thread.currentThread().interrupt();
                                e.printStackTrace();
                            }
                        } else{
                            break;
                        }
                        System.out.println("连队" + i + "已领取武器");
                    }
            }

    }

    public static void main(String[] args) {
        Thread thread = new Thread(new StopThread());
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //thread.interrupt();
        thread.stop();
    }

}
