package excel;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zhaoxiaoping
 * @Description: map 接收数据
 * @Date 2020-11-26
 **/
@Slf4j
public class NoModelDataListener extends AnalysisEventListener<Map<Integer, String>> {

  @Override
  public void invoke(Map<Integer, String> map, AnalysisContext analysisContext) {
    log.info("解析到一条数据 {}", map);
  }

  @Override
  public void doAfterAllAnalysed(AnalysisContext analysisContext) {

  }
}
