package mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

/**
 * 转换器
 *
 * @author zhaoxiaoping
 * @date 2022-10-26
 */
@Mapper
public interface Converter {
  Converter INSTANCE = Mappers.getMapper(Converter.class);

  /**
   * 转换
   *
   * @param source 源
   * @return {@code Target}
   */
//  @Mapping(source = "age", target = "age", resultType = Integer.class)
//  @Mapping(source = "userNick", target = "nick")
//  Target convert(Source source);

  @Mapping(target = "extra", source = "source", qualifiedByName = "convertToExtra")
  DTO convert(Source source);

  @Named("convertToExtra")
  default String convertToExtra(Source source) {
    return String.format("%s,%s", source.getAge(), source.getUserNick());
  }
}
