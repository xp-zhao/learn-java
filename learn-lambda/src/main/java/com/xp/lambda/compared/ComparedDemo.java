package com.xp.lambda.compared;

/**
 * @description: lambda表达式与传统 Java 的对比
 * @author: zhaoxp
 * @create: 2019/04/28
 **/
public class ComparedDemo {
    public static void main(String[] args) {
        // 所有的 lambda 类型都是一个接口，lambda 表达式本身就是一个接口的实现
        // Java8
        MyLambdaInterface code = (s) -> System.out.println(s);
        enact((s) -> System.out.println(s), "Hello World!");
        // Java7
        MyLambdaInterface impl = new MyInterfaceImpl();
        enact(impl,"Hello World!");

    }

    public static void enact(MyLambdaInterface myLambdaInterface, String str){
        myLambdaInterface.dosomething(str);
    }
}