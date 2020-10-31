package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.alibaba.excel.exception.ExcelDataConvertException;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: excel 数据读取监听器
 * @Date 2020-10-31
 **/
@Slf4j
public class ExcelDataListener extends AnalysisEventListener<ExcelData> {

  /**
   * 批量存储到数据库
   */
  private static final int BATCH_COUNT = 100;
  private List<ExcelData> list = new ArrayList<>();

  /**
   * 每条数据解析都会调用这个方法
   *
   * @param excelData
   * @param analysisContext
   */
  @Override
  public void invoke(ExcelData excelData, AnalysisContext analysisContext) {
    log.info("解析到一条数据:{}", excelData.toString());
    list.add(excelData);
    if (list.size() >= BATCH_COUNT) {
      log.info("保存 {} 条数据到数据库", list.size());
      list.clear();
    }
  }

  /**
   * 所有数据解析完成之后，会调用这个方法
   *
   * @param analysisContext
   */
  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {
    log.info("所有数据解析完成");
  }


  @Override
  public void onException(Exception exception, AnalysisContext context) {
    log.error("解析失败，但继续解析下一行：{}", exception.getMessage());
    if (exception instanceof ExcelDataConvertException) {
      ExcelDataConvertException convertException = (ExcelDataConvertException) exception;
      log.error("第{}行，第{}列解析异常", convertException.getRowIndex(), convertException.getColumnIndex());
      ;
    }
  }
}
