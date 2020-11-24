package com.xp.stream.apple;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xp-zhao
 */
public class AppleServer {
    private static List<Apple> appleStore = new ArrayList<>();

    static {
        appleStore.add(new Apple(1, "red", 500, "湖南"));
        appleStore.add(new Apple(2, "red", 400, "湖南"));
        appleStore.add(new Apple(3, "green", 300, "湖南"));
        appleStore.add(new Apple(4, "green", 200, "天津"));
        appleStore.add(new Apple(5, "green", 100, "天津"));
    }

    public void test1(){
        for (Apple apple : appleStore) {
            if (apple.getColor().equals("red")) {
                // add
            }
        }
    }

    public void test2(){
        List<Apple> red = appleStore.stream()
                .filter(a -> a.getColor().equals("red"))
                .collect(Collectors.toList());
    }

    /**
     * 每个颜色的平均重量
     */
    @Test
    public void test3(){
        Map<String, List<Apple>> maps = new HashMap<>();
        // 基于颜色分组
        for (Apple apple : appleStore) {
            List<Apple> list = maps.computeIfAbsent(apple.getColor(), key -> new ArrayList<>());
            list.add(apple);
        }
        maps.forEach((k, v) -> {
            int weights = 0;
            for (Apple apple : v) {
                weights += apple.getWeight();
            }
            System.out.println(String.format("颜色 %s, 平均重量 %s", k, weights / v.size()));
        });
    }

    @Test
    public void test4(){
        Map<String, Double> map = appleStore.stream()
                .collect(Collectors.groupingBy(Apple::getColor, Collectors.averagingInt(Apple::getWeight)));
        System.out.println(map);
    }

    @Test
    public void test5(){
        appleStore.stream()
                .filter(a -> a.getColor().equals("red") || a.getColor().equals("green"))
                .map(a -> a.getColor())
                .distinct()
                .peek(color -> System.out.println(color))
                .toArray();
    }
}
