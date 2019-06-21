package com.xp.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.RandomAccess;

/**
 * @description: RandomAccess标记接口
 * @author: zhaoxiaoping
 * @create: 2019/06/21
 **/
public class RandomAccessTest {

  public static void main(String[] args) {
    long arrayListIndexedTime = arrayListIndexed();
    long arrayListIteratorTime = arrayListIterator();
    long linkedListIndexedTime = linkedListIndexed();
    long linkedListIteratorTime = linkedListIterator();
    System.out.println("测试ArrayList通过for遍历所消耗时间：" + arrayListIndexedTime);
    System.out.println("测试ArrayList通过iterator遍历所消耗时间：" + arrayListIteratorTime);
    System.out.println("测试LinkedList通过for遍历所消耗时间：" + linkedListIndexedTime);
    System.out.println("测试LinkedList通过iterator遍历所消耗时间：" + linkedListIteratorTime);
    List<String> arrayList = new ArrayList<>();
    arrayList.add("a");
    arrayList.add("b");
    traverse(arrayList);

    List<String> linkedList = new LinkedList<>();
    linkedList.add("c");
    linkedList.add("d");
    traverse(linkedList);
  }

  /**
   * 随机访问列表使用循环遍历，顺序访问列表使用迭代器遍历
   */
  public static void traverse(List list) {
    if (list instanceof RandomAccess) {
      System.out.println("实现了 RandomAccess 接口，随机访问列表，直接使用 for 循环访问");
      for (int i = 0; i < list.size(); i++) {
        System.out.println(list.get(i));
      }
    } else {
      System.out.println("没有实现 RandomAccess 接口，顺序访问列表，使用迭代器访问");
      Iterator it = list.iterator();
      while (it.hasNext()) {
        System.out.println(it.next());
      }
    }
  }

  /**
   * 测试 ArrayList 通过 for 遍历所消耗的时间
   */
  public static long arrayListIndexed() {
    List<Integer> arrayList = new ArrayList<>();
    for (int i = 0; i < 1000000; i++) {
      arrayList.add(i);
    }

    // 记录开始时间
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < arrayList.size(); i++) {
      arrayList.get(i);
    }
    // 记录结束时间
    long endTime = System.currentTimeMillis();
    // 遍历消耗时间
    long resultTime = endTime - startTime;
    return resultTime;
  }

  /**
   * 测试ArrayList通过iterator遍历所消耗时间
   */
  public static long arrayListIterator() {
    List<Integer> arrayList = new ArrayList<>();
    for (int i = 0; i < 1000000; i++) {
      arrayList.add(i);
    }

    // 记录开始时间
    long startTime = System.currentTimeMillis();
    Iterator<Integer> iterator = arrayList.iterator();
    while (iterator.hasNext()) {
      iterator.next();
    }
    // 记录结束时间
    long endTime = System.currentTimeMillis();
    // 遍历消耗时间
    long resultTime = endTime - startTime;
    return resultTime;
  }

  //测试LinkedList通过for遍历所消耗时间
  public static long linkedListIndexed() {
    List<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < 10000; i++) {
      linkedList.add(i);
    }
    //记录开始时间
    long startTime = System.currentTimeMillis();
    for (int i = 0; i < linkedList.size(); i++) {
      linkedList.get(i);
    }
    //记录结束时间
    long endTime = System.currentTimeMillis();
    //遍历消耗时间
    long resultTime = endTime - startTime;
    return resultTime;
  }

  //测试LinkedList通过iterator遍历所消耗时间
  public static long linkedListIterator() {
    List<Integer> linkedList = new LinkedList<>();
    for (int i = 0; i < 10000; i++) {
      linkedList.add(i);
    }
    //记录开始时间
    long startTime = System.currentTimeMillis();
    Iterator<Integer> iterator = linkedList.iterator();
    while (iterator.hasNext()) {
      iterator.next();
    }
    //记录结束时间
    long endTime = System.currentTimeMillis();
    //遍历消耗时间
    long resultTime = endTime - startTime;
    return resultTime;
  }
}