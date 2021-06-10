package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/7 - 15:16
 */

import lombok.SneakyThrows;

/**
 * run无法抛出checkedException,只能try/catch
 */
public class RunThrowException {
    public void aCoid() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @SneakyThrows
            @Override
            public void run() {
                throw new Exception();
            }
        });
    }
}
