package json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

/**
 * @author zhaoxiaoping
 * @Description: 动物
 * @Date 2020/5/6
 **/
@Data
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, property = "name", visible = true)
@JsonSubTypes({
    @JsonSubTypes.Type(value = Lion.class, name = "lion"),
    @JsonSubTypes.Type(value = Tiger.class, name = "tiger")
})
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public abstract class Animal {

  private String name;
  private Integer age;
}
