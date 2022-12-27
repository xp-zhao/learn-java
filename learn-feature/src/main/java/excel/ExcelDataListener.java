package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

/**
 * excel 数据读取监听器
 *
 * @author zhaoxiaoping
 * @date 2022-12-26
 */
public class ExcelDataListener extends AnalysisEventListener<ExcelData> {

  @Override
  public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
    System.out.println("手机号: " + excelData.getPhone());
    System.out.println("金额: " + excelData.getMoney());
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    System.out.println("数据读取结束");
  }
}
