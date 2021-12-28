package mapstruct1.target1;

import com.fasterxml.jackson.databind.deser.impl.PropertyValue;
import java.util.List;
import lombok.Data;

/**
 * @author zhaoxiaoping
 * @date 2021-12-28
 */
@Data
public class PropertyItem {
  private String key;
  private List<PropertyValue> value;
}
