package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/9 - 10:07
 */


/**
 * TODD object wait()和notify()的基本方法方法
 * 1.研究代码的执行顺序:
 * 2.证明wait释放锁
 */
public class Wait {
    public static Object object = new Object();

    static class Thread1 extends Thread {

        @Override
        public void run() {
            //放在sync代码块中，否则执行报错
            synchronized (object) {
                System.out.println("线程1开始执行" + Thread.currentThread().getName());
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("线程" + Thread.currentThread().getName() + "获取锁");
            }
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            //放在sync代码块中，否则执行报错
            synchronized (object) {
                object.notify();
                System.out.println("线程" + Thread.currentThread().getName() + "调用notify");
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2();
        thread1.start();
        //让线程1开始执行
        Thread.sleep(200);
        thread2.start();
    }
}
