package mapstruct1;

import mapstruct1.source.SourceDTO;
import mapstruct1.target1.TargetDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

/**
 * 转换器
 *
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Mapper
public interface ConverterExample {
  ConverterExample INSTANCE = Mappers.getMapper(ConverterExample.class);

  TargetDTO convert(SourceDTO source);
}
