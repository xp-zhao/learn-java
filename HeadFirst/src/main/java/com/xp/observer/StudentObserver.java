package com.xp.observer;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.Observable;
import java.util.Observer;

/**
 * @author xp-zhao
 * @description: 观察者：学生
 * @date 2021/4/1
 */
@RequiredArgsConstructor
public class StudentObserver implements Observer {

  @NonNull private String name;
  private String task;

  @Override
  public void update(Observable o, Object arg) {
    TeacherObservable teacherObservable = (TeacherObservable) o;
    this.task = teacherObservable.getTask();
    System.out.printf("学生：%s，老师布置了作业：%s\n", this.name, this.task);
  }
}
