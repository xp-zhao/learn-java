package com.xp.hutool;

import cn.hutool.core.io.file.FileWriter;
import com.alibaba.fastjson.JSONObject;
import com.xp.basics.Student;

/**
 * @author zhaoxiaoping
 * @Description: 文件操作
 * @Date 2020/3/27
 **/
public class FileDemo {

  public static void main(String[] args) {
    FileWriter fw = new FileWriter("test.json");
    Student student = new Student();
    student.setStudentId("1");
    student.setName("xp");
    fw.write(JSONObject.toJSONString(student));
  }
}
