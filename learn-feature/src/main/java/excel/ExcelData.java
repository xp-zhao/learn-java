package excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2022-12-26
 */
@Data
public class ExcelData {
  @ExcelProperty(value = "手机号")
  private String phone;

  @ExcelProperty(value = "金额")
  private String money;
}
