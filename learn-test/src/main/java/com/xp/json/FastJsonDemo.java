package com.xp.json;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * FastJsonDemo.java fastJson 测试
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/02
 **/
public class FastJsonDemo {

  public static void main(String[] args) {
    TestModel model = new TestModel();
    System.out.println(model);
    // 默认忽略掉为空的字段
    System.out.println(JSONObject.toJSONString(model));
    // 显示为空的字段
    System.out.println(JSONObject.toJSONString(model, SerializerFeature.WriteMapNullValue));
  }
}