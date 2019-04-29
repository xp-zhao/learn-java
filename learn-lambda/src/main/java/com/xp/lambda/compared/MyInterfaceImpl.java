package com.xp.lambda.compared;

/**
 * @description: 接口实现
 * @author: zhaoxp
 * @create: 2019/04/28
 **/
public class MyInterfaceImpl implements MyLambdaInterface {

    @Override
    public void dosomething(String str) {
        System.out.println(str);
    }
}