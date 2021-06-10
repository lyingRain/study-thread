package com.thread.study.stopthread.volatiledemo;

/**
 * @author zzxstart
 * @date 2021/6/7 - 19:44
 */

import lombok.Data;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 用volatile的局限part2
 * 陷入阻塞时，volatile是无法停止线程的
 * 生产者生产速度快，消费者消费速度慢，所以阻塞队列满了以后，生产者阻塞
 */
public class WrongWayVolatileCantStop {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<Object> storage = new ArrayBlockingQueue<>(10);
        Product product = new Product(storage);
        Thread productThread = new Thread(product);
        productThread.start();
        Thread.sleep(1000);

        Consumer consumer = new Consumer(storage);
        while (consumer.needMoreNUms()) {
            System.out.println(consumer.storage.take() + "被消费了");
            Thread.sleep(100);
        }
        System.out.println("消费者不需要更多数据了");
        //一旦消费者不需要更多数据了，我们应该让生产者停下来。
        product.cancle = true;
        System.out.println(product.cancle);
    }
}

@Data
class Product implements Runnable {
    public volatile boolean cancle = false;

    BlockingQueue storage;

    public Product(BlockingQueue storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        int num = 0;
        try {
            while (num <= 10000 && !cancle) {
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