package model;

import java.util.List;
import lombok.Data;

/**
 * 文章对象
 *
 * @author zhaoxiaoping
 * @date 2022-8-16
 */
@Data
public class Article {
  private String id;

  private String title;

  private String content;

  private List<Author> authors;
}
