package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/4 - 17:23
 */

/**
 * 如果while里面放try/catch，会导致中断失效
 */
public class CantInterrept {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () ->{
            int num = 0;
          while (num <= 10000){
              if (num % 100 ==0 &&!Thread.currentThread().isInterrupted()){
                  System.out.println(num+"倍数");
              }
              num++;
              try {
                  Thread.sleep(10);
              } catch (InterruptedException e) {
                  e.printStackTrace();
              }
          }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.interrupt();
    }
}
