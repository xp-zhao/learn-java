package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: excel 数据对象
 * @Date 2020-10-31
 **/
@Data
public class ExcelIndexData {

  @ExcelProperty(index = 0)
  private String content;
  @ExcelProperty(index = 1)
  private String id;
}
