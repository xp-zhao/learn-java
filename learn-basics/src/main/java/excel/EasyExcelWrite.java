package excel;

import com.alibaba.excel.EasyExcel;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description: easyexcel 写 excel 示例
 * @Date 2020-10-31
 **/
public class EasyExcelWrite {

  public static void main(String[] args) {
    String filePath = "D:\\data\\excel\\写入excel测试.xlsx";
    List<ExcelData> list = new ArrayList<>();
    for (int i = 0; i < 10; i++) {
      ExcelData data = new ExcelData();
      data.setString("字符串" + i);
      data.setDate(LocalDateTime.now());
      data.setDoubleData(i);
      list.add(data);
    }
    EasyExcel.write(filePath, ExcelData.class).sheet("模板").doWrite(list);
  }
}
