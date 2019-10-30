package stream.collector;

import lombok.Builder;
import lombok.Data;

/**
 * Book.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/10/30
 **/
@Builder
@Data
public class Book {

  private String name;
  private int releaseYear;
  private String isbn;
}