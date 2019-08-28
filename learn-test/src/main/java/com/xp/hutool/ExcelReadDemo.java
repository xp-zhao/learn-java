package com.xp.hutool;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import java.util.List;
import java.util.Map;

/**
 * ExcelReadDemo.java excel 读取示例
 *
 * @author: zhaoxiaoping
 * @date: 2019/08/28
 **/
public class ExcelReadDemo {

  public static void main(String[] args) {
    ExcelReader reader = ExcelUtil.getReader("D:\\优学派\\项目文档\\互动试题\\B端允许的标签汇总.xlsx");
    List<List<Object>> readAll = reader.read();
    System.out.println(readAll.size());
    List<Map<String,Object>> map = reader.readAll();
    System.out.println(map.size());
  }
}