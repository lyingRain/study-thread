package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/7 - 14:40
 */


import lombok.extern.slf4j.Slf4j;

/**
 * 最佳实践：catch了InterruptedExceptiony之后的优先选择：再方法签名中抛出异常
 * 那么在run()J就会强制try/catch
 */
@Slf4j
public class RightWayStopThreadProduct implements Runnable {
    @Override
    public void run() {
        while (true && !Thread.currentThread().isInterrupted()){
            System.out.println("go");
            try {
                throwMethod();
            } catch (InterruptedException e) {
                //保存日志，停止程序
                log.info("日志");
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
        }
    }
    private void throwMethod() throws InterruptedException {
        //try/catch  不好，较低层次，没有往上（调用方）传

      /*  try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();// 不应该吞掉
        }*/
      //方法签名抛出
      Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadProduct());
        thread.start();
        Thread.sleep(300);
        thread.interrupt();

    }
}
