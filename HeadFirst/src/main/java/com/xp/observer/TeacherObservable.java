package com.xp.observer;

import lombok.Getter;

import java.util.Observable;

/**
 * @author xp-zhao
 * @description: 观察目标：老师
 * @date 2021/4/1
 */
@Getter
public class TeacherObservable extends Observable {
  private String task;

  /**
   * 老师布置作业
   *
   * @param task
   */
  public void publish(String task) {
    this.task = task;
    // 改变状态
    this.setChanged();
    // 通知所有观察者
    this.notifyObservers();
  }
}
