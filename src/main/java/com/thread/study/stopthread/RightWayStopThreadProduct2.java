package com.thread.study.stopthread;

/**
 * @author zzxstart
 * @date 2021/6/7 - 14:40
 */


import lombok.extern.slf4j.Slf4j;

/**
 * 最佳实践：在catch字与句中调用Thread.CurrentThread().interrupte()来恢复设置中断状态，以便于在后续的执行中，
 * 依然能够检查到刚才发生了中断，回到刚才RightWayStopThreadProduct补上中断，让其跳出
 */
@Slf4j
public class RightWayStopThreadProduct2 implements Runnable {
    @Override
    public void run() {
        while (true ){
            if (Thread.currentThread().isInterrupted()){
                System.out.println("运行结束");
                break;
            }
            reInterrupt();
        }
    }
//try/catch  不好，较低层次
    private void reInterrupt() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            //设置中断，不要信息独吞，上一层感知不到
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThreadProduct2());
        thread.start();
        Thread.sleep(300);
        thread.interrupt();

    }
}
