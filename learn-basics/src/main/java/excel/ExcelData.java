package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @Description: excel 数据对象
 * @Date 2020-10-31
 **/
@Data
public class ExcelData {

  @ExcelProperty(value = "字符串格式")
  private String string;
  @ExcelProperty(value = "时间格式", converter = LocalDateTimeStringConverter.class)
  private LocalDateTime date;
  @ExcelProperty(value = "数字格式")
  private Integer doubleData;
}
