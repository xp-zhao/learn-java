package excel;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zhaoxiaoping
 * @Description: 时间类型转换器
 * @Date 2020-10-31
 **/
public class LocalDateTimeStringConverter implements Converter<LocalDateTime> {

  private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

  @Override
  public Class supportJavaTypeKey() {
    return LocalDateTime.class;
  }

  @Override
  public CellDataTypeEnum supportExcelTypeKey() {
    return CellDataTypeEnum.STRING;
  }

  @Override
  public LocalDateTime convertToJavaData(CellData cellData,
      ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
      throws Exception {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    LocalDateTime dateTime = LocalDateTime.parse(cellData.getStringValue(), formatter);
    return dateTime;
  }

  @Override
  public CellData convertToExcelData(LocalDateTime localDateTime,
      ExcelContentProperty excelContentProperty, GlobalConfiguration globalConfiguration)
      throws Exception {
    return new CellData(localDateTime.format(DateTimeFormatter.ofPattern(DATE_FORMAT)));
  }
}
