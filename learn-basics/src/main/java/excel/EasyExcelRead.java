package excel;

import com.alibaba.excel.EasyExcel;

/**
 * @author zhaoxiaoping
 * @Description: 使用 easyexcel 读取 excel
 * @Date 2020-10-31
 **/
public class EasyExcelRead {

  public static void main(String[] args) {
//    String filePath = "D:\\data\\excel\\书本索引信息.xlsx";
//    EasyExcel.read(filePath, ExcelData.class, new ExcelDataListener()).sheet().doRead();
    String filePath = "D:\\data\\excel\\xxx.xlsx";
    EasyExcel.read(filePath, ExcelIndexData.class, new ExcelIndexDataListener()).sheet().headRowNumber(0).doRead();
  }
}
