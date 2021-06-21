package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/15 - 10:02
 */

/**
 * 两个线程交替打印0-100的奇数偶数，用sync关键字.存在资源浪费
 */
public class WaitNotifyPrintOddEvenSyn {
    private static int count;
    public static final Object lock = new Object();

    //创建两个线程 ，一个只处理奇数，一个处理偶数（用位运算），Sync做通信
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        //使用位运算 如果为正数，补码与原码相同，直接看最后一位（因为数字1的前面N位均为0，跟它做与运算，前面肯定为0），奇数为1，偶数为0，与1相与，结果不变。
                        if ((count & 1) == 0) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);

                        }
                    }
                }
            }
        }, "偶数").start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (count < 100) {
                    synchronized (lock) {
                        //使用位运算 如果为正数，补码与原码相同，直接看最后一位（因为数字1的前面N位均为0，跟它做与运算，前面肯定为0），奇数为1，偶数为0，与1相与，结果不变。
                        if ((count & 1) == 1) {
                            System.out.println(Thread.currentThread().getName() + ":" + count++);

                        }
                    }
                }
            }
        }, "奇数").start();
    }

}
