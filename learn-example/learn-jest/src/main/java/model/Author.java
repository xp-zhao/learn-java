package model;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Data
public class Author {
  @Field(type = FieldType.Text)
  private String name;

  @Field(type = FieldType.Integer)
  private Integer age;
}
