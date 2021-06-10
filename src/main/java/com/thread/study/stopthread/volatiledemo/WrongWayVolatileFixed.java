package com.thread.study.stopthread.volatiledemo;

/**
 * @author zzxstart
 * @date 2021/6/7 - 21:18
 */

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用中断来修复无尽等待的问题   内部类
 */

public class WrongWayVolatileFixed {
    public static void main(String[] args) throws InterruptedException {
        //内部类要先实现外部的类
        WrongWayVolatileFixed body = new WrongWayVolatileFixed();
        ArrayBlockingQueue<Object> storage = new ArrayBlockingQueue<>(10);
        //然后实现内部类
        Product product = body.new Product(storage);
        Thread productThread = new Thread(product);
        productThread.start();
        Thread.sleep(1000);

        Consumer consumer = body.new Consumer(storage);
        while (consumer.needMoreNUms()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        productThread.interrupt();
        //一旦消费者不需要更多数据了，我们应该让生产者停下来。
    }


    @Data
    class Product implements Runnable {

        BlockingQueue storage;

        public Product(BlockingQueue storage) {
            this.storage = storage;
        }

        @Override
        public void run() {
            int num = 0;
            try {
                while (num <= 10000 && !Thread.currentThread().isInterrupted()) {
                    if (num % 100 == 0) {
                        storage.put(num);
                        System.out.println(num + "是一百倍数,被放进仓库中");
                    }
                    num++;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("生产者结束");
            }
        }
    }

    @Data
    class Consumer {
        BlockingQueue storage;

        public Consumer(BlockingQueue storage) {
            this.storage = storage;
        }

        public boolean needMoreNUms() {
            if (Math.random() > 0.95) {
                return false;
            } else {
                return true;
            }
        }
    }
}