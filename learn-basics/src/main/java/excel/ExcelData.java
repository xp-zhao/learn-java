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

  private String string;
  @ExcelProperty(converter = LocalDateTimeStringConverter.class)
  private LocalDateTime date;
  private Integer doubleData;
}
