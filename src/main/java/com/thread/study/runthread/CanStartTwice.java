package com.thread.study.runthread;

/**
 * @author zzxstart
 * @date 2021/6/3 - 15:08
 */

/**
 * 不能两次调用start方法，否则会报错
 */
public class CanStartTwice {
    public static void main(String[] args) {
        Thread thread = new Thread(){
            @Override
            public void run() {
                System.out.println(1);            }
        };
        thread.start();
        thread.start();
    }
}
