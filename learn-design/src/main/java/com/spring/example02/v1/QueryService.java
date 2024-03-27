package com.spring.example02.v1;

import com.spring.example02.PageResult;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
public class QueryService {
  public PageResult queryBook(BookRequest request) {
    PageResult result = new PageResult();
    int count = queryBookCount(request);
    result.setCount(count);
    if (count == 0) {
      return result;
    }
    List<BookDTO> dtoList = queryBookList(request);
    result.setResult(dtoList);
    return result;
  }

  public PageResult queryPencil(PencilRequest request) {
    PageResult result = new PageResult();
    int count = queryPencilCount(request);
    result.setCount(count);
    if (count == 0) {
      return result;
    }
    List<PencilDTO> dtoList = queryPencilList(request);
    result.setResult(dtoList);
    return result;
  }

  private int queryBookCount(BookRequest request) {
    return 0;
  }

  private List<BookDTO> queryBookList(BookRequest request) {
    return new ArrayList<>();
  }

  private int queryPencilCount(PencilRequest request) {
    return 0;
  }

  private List<PencilDTO> queryPencilList(PencilRequest request) {
    return new ArrayList<>();
  }
}
