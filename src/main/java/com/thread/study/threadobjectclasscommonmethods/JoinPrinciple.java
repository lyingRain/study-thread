package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/15 - 17:52
 */

/**
 * 通过讲解join原理，分析出join的代替方法
 */
public class JoinPrinciple {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "执行完毕");
            }
        });
        thread.start();
        System.out.println("开始等待子线程运行完毕");
        //thread.join();  等价于如下
        synchronized (thread){
            thread.wait();
        }
        System.out.println("所有子线程执行完毕");
    }

}
