package com.xp.hutool;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: excel导出demo
 * @author: zhaoxiaoping
 * @create: 2019/06/16
 **/
public class ExcelDemo {

  public static void main(String[] args) {
//    writeListToExcel();
//    writeMapToExcel();
    writeTwoSheetExcel();
  }

  private static void writeTwoSheetExcel(){
    Map<String, Object> row1 = new LinkedHashMap<>();
    row1.put("姓名", "张三");
    row1.put("年龄", 23);
    row1.put("成绩", 88.32);
    row1.put("是否合格", true);
    row1.put("考试日期", DateUtil.date());

    Map<String, Object> row2 = new LinkedHashMap<>();
    row2.put("姓名", "李四");
    row2.put("年龄", 33);
    row2.put("成绩", 59.50);
    row2.put("是否合格", false);
    row2.put("考试日期", DateUtil.date());

    ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);

    List<String> list1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
    List<String> list2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
    List<String> list3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
    List<String> list4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
    List<String> list5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");

    List<List<String>> list = CollUtil.newArrayList(list1, list2, list3, list4, list5);

    // 通过工具类创建 writer
    ExcelWriter writer = ExcelUtil.getWriter("D:\\user\\hutool\\excel\\writeTwoSheetTest.xlsx");
    // 合并单元格后的标题行，使用默认标题样式
    writer.merge(row1.size() - 1, "成绩单");
    // 一次性写出内容，强制输出标题
    writer.write(rows, true);
    writer.setSheet("表1");
    writer.merge(list.size() - 1, "测试");
    writer.write(list, true);
    // 关闭 writer，释放内存
    writer.close();
  }

  private static void writeMapToExcel(){
    Map<String, Object> row1 = new LinkedHashMap<>();
    row1.put("姓名", "张三");
    row1.put("年龄", 23);
    row1.put("成绩", 88.32);
    row1.put("是否合格", true);
    row1.put("考试日期", DateUtil.date());

    Map<String, Object> row2 = new LinkedHashMap<>();
    row2.put("姓名", "李四");
    row2.put("年龄", 33);
    row2.put("成绩", 59.50);
    row2.put("是否合格", false);
    row2.put("考试日期", DateUtil.date());

    ArrayList<Map<String, Object>> rows = CollUtil.newArrayList(row1, row2);

    // 通过工具类创建 writer
    ExcelWriter writer = ExcelUtil.getWriter("D:\\user\\hutool\\excel\\writeMapTest.xlsx");
    // 合并单元格后的标题行，使用默认标题样式
    writer.merge(row1.size() - 1, "成绩单");
    // 一次性写出内容，强制输出标题
    writer.write(rows, true);
    // 关闭 writer，释放内存
    writer.close();
  }

  private static void writeListToExcel() {
    List<String> row1 = CollUtil.newArrayList("aa", "bb", "cc", "dd");
    List<String> row2 = CollUtil.newArrayList("aa1", "bb1", "cc1", "dd1");
    List<String> row3 = CollUtil.newArrayList("aa2", "bb2", "cc2", "dd2");
    List<String> row4 = CollUtil.newArrayList("aa3", "bb3", "cc3", "dd3");
    List<String> row5 = CollUtil.newArrayList("aa4", "bb4", "cc4", "dd4");

    List<List<String>> rows = CollUtil.newArrayList(row1, row2, row3, row4, row5);

    // 通过工具类创建 writer
    ExcelWriter writer = ExcelUtil.getWriter("D:\\user\\hutool\\excel\\writeTest.xlsx");
    // 跳过当前行（第一行）
    writer.passCurrentRow();
    writer.autoSizeColumn(1);
    // 合并单元格后的标题行，使用默认标题样式
    writer.merge(row1.size() - 1, "测试标题");
    // 一次性写出内容，强制输出标题
    writer.write(rows, true);
    // 关闭 writer，释放内存
    writer.close();
  }
}