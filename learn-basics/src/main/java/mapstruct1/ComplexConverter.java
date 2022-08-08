package mapstruct1;

import java.util.List;
import mapstruct1.source.ComplexDTO;
import mapstruct1.source.ComplexDTO.AddressDTO;
import mapstruct1.target1.ComplexVO;
import mapstruct1.target1.ComplexVO.AddressVO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * 复杂对象转换器
 *
 * @author zhaoxiaoping
 * @date 2022-8-8
 */
@Mapper
public interface ComplexConverter {

  ComplexConverter INSTANCE = Mappers.getMapper(ComplexConverter.class);

  /**
   * dto对象转vo对象
   *
   * @param dto dto
   * @return {@code ComplexVO}
   */
  ComplexVO dtoToVo(ComplexDTO dto);

  /**
   * dto对象转vo对象
   *
   * @param dto dto
   * @return {@code AddressVO}
   */
  @Mappings({@Mapping(source = "key", target = "id"), @Mapping(source = "value", target = "name")})
  AddressVO dtoToVo(AddressDTO dto);

  List<AddressVO> dtoToVo(List<AddressDTO> dto);
}
