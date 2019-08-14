package com.xp.basics.string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * SwithDemo.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/08
 **/
public class SwithDemo {

  public static void main(String[] args) {

    List<String> property = Arrays
        .asList("n.node_id", "n.name", "n.knowledge_type", "n.important", "n.difficut", "n.electives",
            "n.ability", "n.require", "n.require1", "n.require2", "n.require3", "n.BSDB_is_meta", "n.RJB_is_meta",
            "n.point1", "n.point2", "n.point3", "n.point4");
    String str = property.stream().collect(Collectors.joining(","));
    String cql = "match (n) where id(n) = %s remove %s";
    System.out.println(String.format(cql, 11, str));

    Map<String, Object> map = new HashMap<>();
    System.out.println(Optional.ofNullable(map.get("key")).orElse(""));
    String[] point = {"1", "2", "3"};
    Demo demo = new Demo();
    setPoint(demo, point);
    System.out.println(demo);
  }

  public static void setPoint(Demo demo, String[] point) {
    switch (point.length) {
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