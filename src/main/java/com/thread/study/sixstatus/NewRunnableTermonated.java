package com.thread.study.sixstatus;

/**
 * @author zzxstart
 * @date 2021/6/8 - 14:45
 */

/**
 * TODD 展示线程的new runnable terminated,即使是正在运行，也是Runnable状态
 */
public class NewRunnableTermonated  implements Runnable{
    public static void main(String[] args) {
        Thread thread = new Thread(new NewRunnableTermonated());
        System.out.println(thread.getState());
        thread.start();
        System.out.println(thread.getState());
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //运行中的状态也是Runnable 而不是 Running
        System.out.println(thread.getState());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Terminatedz状态
        System.out.println(thread.getState());
    }
    @Override
    public void run() {
        for (int i = 0; i <1000 ; i++) {
            System.out.println(i);
        }
    }
}
