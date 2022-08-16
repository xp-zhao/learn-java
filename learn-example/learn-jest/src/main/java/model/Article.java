package model;

import java.util.List;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 文章对象
 *
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Data
@Document(indexName = "text")
public class Article {
  @Id private String id;

  @Field(type = FieldType.Text)
  private String title;

  @Field(type = FieldType.Text)
  private String randomText;

  @Field(type = FieldType.Nested, includeInParent = true)
  private List<Author> authors;
}
