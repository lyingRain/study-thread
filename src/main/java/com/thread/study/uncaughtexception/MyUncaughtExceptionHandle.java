package com.thread.study.uncaughtexception;

/**
 * @author zzxstart
 * @date 2021/6/21 - 10:08
 */

import lombok.extern.slf4j.Slf4j;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 自己的MyUncaughtExceptionHandle,全局异常处理
 */
@Slf4j
public class MyUncaughtExceptionHandle implements Thread.UncaughtExceptionHandler {
    //给自定义的handle命名
    private String name;

    public MyUncaughtExceptionHandle(String name) {
        this.name = name;
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        Logger logger = Logger.getAnonymousLogger();
        logger.log(Level.WARNING, "线程异常，终止了" + t.getName(), e);
        System.out.println(name + "捕获异常!");

    }
}
