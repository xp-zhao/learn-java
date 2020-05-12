package com.poi;

import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
public class ExcelWriteTest {

  String PATH = "D:\\driver";

  @Test
  public void testWrite03() {
    // 1. 创建一个工作簿
    Workbook workbook = new HSSFWorkbook();
    // 2. 创建一个工作表
    Sheet sheet = workbook.createSheet("测试");
    // 3. 创建一行
    Row row1 = sheet.createRow(0);
    // 4. 创建一个单元格
    Cell cell1 = row1.createCell(0);
    cell1.setCellValue("人数");
    // (1,2)
    Cell cell2 = row1.createCell(1);
    cell2.setCellValue(666);

    // 第二行
    Row row2 = sheet.createRow(1);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("统计时间");

    Cell cell22 = row2.createCell(1);
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    cell22.setCellValue(now.format(formatter));

    // 生成一张表
    try (FileOutputStream fos = new FileOutputStream(PATH + "/test03.xls")) {
      // 输出
      workbook.write(fos);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("excel 生成完毕");
  }

  @Test
  public void testWrite07() {
    // 1. 创建一个工作簿
    Workbook workbook = new XSSFWorkbook();
    // 2. 创建一个工作表
    Sheet sheet = workbook.createSheet("测试");
    // 3. 创建一行
    Row row1 = sheet.createRow(0);
    // 4. 创建一个单元格
    Cell cell1 = row1.createCell(0);
    cell1.setCellValue("人数");
    // (1,2)
    Cell cell2 = row1.createCell(1);
    cell2.setCellValue(666);

    // 第二行
    Row row2 = sheet.createRow(1);
    Cell cell21 = row2.createCell(0);
    cell21.setCellValue("统计时间");

    Cell cell22 = row2.createCell(1);
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    cell22.setCellValue(now.format(formatter));

    // 生成一张表
    try (FileOutputStream fos = new FileOutputStream(PATH + "/test07.xlsx")) {
      // 输出
      workbook.write(fos);
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("excel 生成完毕");
  }

  public static void main(String[] args) {
    LocalDateTime now = LocalDateTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    System.out.println(now.format(formatter));
  }
}
