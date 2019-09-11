package com.xp.thread.juc;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * CustomCheckWindow.java Semaphore 使用示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/11
 **/
public class CustomCheckWindow {

  public static void main(String[] args) {
    // 设置三个信号量
    Semaphore semaphore = new Semaphore(3);
    for (int i = 1; i < 5; i++) {
      new SecurityCheckThread(i, semaphore).start();
    }
  }

  private static class SecurityCheckThread extends Thread{

    private int seq;
    private Semaphore semaphore;

    public SecurityCheckThread(int seq, Semaphore semaphore){
      this.seq = seq;
      this.semaphore = semaphore;
    }

    @Override
    public void run() {
      try {
        semaphore.acquire();
        System.out.println("No." + seq + "乘客，正在查验中");
        if(seq % 2 == 0){
          TimeUnit.SECONDS.sleep(2);
          System . out . println("No." + seq + " 乘客,身份可疑不能出国！");
        }
      } catch (InterruptedException e) {
        e.printStackTrace();
      } finally {
        semaphore.release();
        System.out.println("No." + seq + " 乘客,已完成服务");
      }
    }
  }
}