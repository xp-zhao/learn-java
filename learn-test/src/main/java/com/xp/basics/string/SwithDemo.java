package com.xp.basics.string;

/**
 * SwithDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/08
 **/
public class SwithDemo {

  public static void main(String[] args) {
    String[] point = {"1", "2", "3"};
    Demo demo = new Demo();
    setPoint(demo, point);
    System.out.println(demo);
  }

  public static void setPoint(Demo demo, String[] point){
    switch (point.length){
      case 4:
        demo.setPoint4(point[3]);
      case 3:
        demo.setPoint3(point[2]);
      case 2:
        demo.setPoint2(point[1]);
      case 1:
        demo.setPoint1(point[0]);
    }
  }
}