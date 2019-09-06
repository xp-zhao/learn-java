package com.xp.basics;

/**
 * ParamPassing.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/09/06
 **/
public class ParamPassing {

  private static int intStatic = 222;
  private static String stringStatic = "old string";
  private static StringBuilder stringBuilderStatic = new StringBuilder("old stringBuilder");

  public static void main(String[] args) {
    method(intStatic);
    method(stringStatic);
    method(stringBuilderStatic, stringBuilderStatic);

    System.out.println(intStatic);
    method();
    System.out.println(intStatic);
    System.out.println(stringStatic);
    System.out.println(stringBuilderStatic);
  }

  public static void method(int intStatic){
    intStatic = 777;
  }

  public static void method(){
    intStatic = 888;
  }

  public static void method(String stringStatic){
    stringStatic = "new string";
  }

  public static void method(StringBuilder s1, StringBuilder s2){
    s1.append(".method.first-");
    s2.append(".methdd.second-");

    s1 = new StringBuilder("new stringBuilder");
    s1.append("new method's append");
  }
}