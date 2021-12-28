package mapstruct1;

import java.util.Arrays;
import mapstruct1.source.KeyValueDTO;
import mapstruct1.source.PropertyDTO;
import mapstruct1.source.SourceDTO;
import mapstruct1.source.ValueDTO;
import mapstruct1.target1.TargetDTO;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
public class Example {
  public static void main(String[] args) {
    SourceDTO dto = new SourceDTO();
    dto.setId("111");
    dto.setContent(Arrays.asList(new KeyValueDTO("题干", "xxx"), new KeyValueDTO("答案", "xxx")));
    dto.setProperty(
        Arrays.asList(
            new PropertyDTO("xxx", Arrays.asList(new ValueDTO("", "", "", "")), "skill")));
    SourceDTO dto1 = new SourceDTO();
    dto1.setId("111");
    dto1.setContent(Arrays.asList(new KeyValueDTO("题干", "xxx"), new KeyValueDTO("答案", "xxx")));
    dto.setChildList(Arrays.asList(dto1));
    System.out.println(dto);
    TargetDTO target = mapstruct1.ConverterExample.INSTANCE.convert(dto);
    System.out.println(target);
  }
}
