package com.thread.study.threadobjectclasscommonmethods;

/**
 * @author zzxstart
 * @date 2021/6/16 - 9:12
 */

/**
 * ID从1开始，JVM运行起来后。我们自己创建的线程早已不是0
 */
public class ThreadId {
    public static void main(String[] args) {
        Thread thread = new Thread("sohuhu");
        //main
        System.out.println("主线程ID"+Thread.currentThread().getId());
        //12
        System.out.println("子线程ID"+thread.getId());
        System.out.println("子线程ID"+thread.getName());
        thread.setDaemon(true);
        System.out.println(thread.isDaemon());
    }
}
