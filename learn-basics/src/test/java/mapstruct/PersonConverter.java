package mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @author zhaoxiaoping
 * @Description: 对象转换接口
 * @Date 2020-8-12
 **/
@Mapper
public interface PersonConverter {

  PersonConverter INSTANCE = Mappers.getMapper(PersonConverter.class);

  @Mapping(source = "name", target = "userName")
  PersonDTO do2dto(PersonDO person);
}
