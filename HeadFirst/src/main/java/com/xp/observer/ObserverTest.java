package com.xp.observer;

/**
 * @author xp-zhao
 * @description: 观察者模式测试
 * @date 2021/4/1
 */
public class ObserverTest {
  public static void main(String[] args) {
    // 创建观察目标
    TeacherObservable teacherObservable = new TeacherObservable();
    // 添加观察者
    teacherObservable.addObserver(new StudentObserver("张三"));
    teacherObservable.addObserver(new StudentObserver("李四"));
    teacherObservable.addObserver(new StudentObserver("王五"));
    // 布置任务
    teacherObservable.publish("背诵一首古诗词");
  }
}
