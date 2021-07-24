package com.thread.study.threadsafe;

/**
 * @author zzxstart
 * @date 2021/6/21 - 15:25
 */

import com.thread.study.createthread.wrongways.TestClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一种：运行结果出错  a++
 * 演示 计数不准确（减少），找出具体出错的位置
 */
public class MultiThreadsError implements Runnable {
    int index = 0;
    static AtomicInteger realIndex = new AtomicInteger();
    static AtomicInteger wrongIndex = new AtomicInteger();
    final boolean[] marked = new boolean[10000000];
    static MultiThreadsError instance = new MultiThreadsError();

    public static void main(String[] args) throws InterruptedException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        //创建Class对象
        Class aClass = Class.forName("com.thread.study.createthread.wrongways.TestClass");
        //访问所有公有字段(public修饰)
        Field[] fields = aClass.getFields();
        //获取单个公有方法
        Method method = aClass.getMethod("test",int.class);
        TestClass o =(TestClass) aClass.getDeclaredConstructor().newInstance();
        //调用方法并传参
        method.invoke(o,2);
        System.out.println("获取值");
        //返回某一个公有字段的值
        Field code = aClass.getField("code");
        //获取所有构造方法
        Constructor constructor1 = aClass.getDeclaredConstructor();
        //暴力访问（忽略访问修饰符）
        constructor1.setAccessible(true);
        //私有构造方法创建对象
        TestClass testClass1 = (TestClass) constructor1.newInstance();
        //为code赋值
        code.set(testClass1,3);
        System.out.println(testClass1.getCode());
        //访问获取字段（任何修饰符修饰）
        Field[] declaredFields = aClass.getDeclaredFields();
        System.out.println(declaredFields.length);
        Constructor constructor = aClass.getDeclaredConstructor();
        //暴力访问（忽略访问修饰符）
        constructor.setAccessible(true);
        //私有构造方法创建对象
        TestClass testClass = (TestClass) constructor.newInstance();
        testClass.setDate(1);
        System.out.println(testClass.getCode());
       /* Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        //主线程等待子线程执行完
        thread1.join();
        thread2.join();
        System.out.println("表面上运行结果"+instance.index);
        System.out.println("真正运行的次数"+realIndex.get());
        System.out.println("错误运行的次数"+wrongIndex.get());*/

    }

    @Override
    public void run() {
        /*while (index < 10000) {
            index++;
        }*/
        for (int i = 0; i < 10000; i++) {
            index++;
            realIndex.incrementAndGet();
            if (marked[index]) {
                System.out.println("发生错误" + index);
                wrongIndex.incrementAndGet();
            }
            marked[index] = true;
        }
    }
}
