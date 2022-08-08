package mapstruct1;

import java.util.Arrays;
import mapstruct1.source.ComplexDTO;
import mapstruct1.source.ComplexDTO.AddressDTO;
import mapstruct1.target1.ComplexVO;

/**
 * @author zhaoxiaoping
 * @date 2022-8-8
 */
public class ComplexExample {
  public static void main(String[] args) {
    ComplexDTO dto = new ComplexDTO();
    dto.setId("id");
    dto.setName("name");
    AddressDTO a1 = new AddressDTO();
    a1.setKey("k1");
    a1.setValue("v1");
    AddressDTO a2 = new AddressDTO();
    a2.setKey("k2");
    a2.setValue("v2");
    dto.setAddressList(Arrays.asList(a1, a2));
    ComplexVO vo = ComplexConverter.INSTANCE.dtoToVo(dto);
    System.out.println(vo);
  }
}
