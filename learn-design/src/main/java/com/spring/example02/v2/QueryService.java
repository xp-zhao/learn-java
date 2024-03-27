package com.spring.example02.v2;

import com.spring.example02.PageResult;
import com.spring.example02.v1.BookDTO;
import com.spring.example02.v1.BookRequest;
import com.spring.example02.v1.PencilDTO;
import com.spring.example02.v1.PencilRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author zhaoxiaoping
 * @date 2024-3-27
 */
public class QueryService {

  public PageResult queryBook(BookRequest request) {
    return buildPageResult(() -> queryBookCount(request), () -> queryBookList(request));
  }

  public PageResult queryPencil(PencilRequest request) {
    return buildPageResult(() -> queryPencilCount(request), () -> queryPencilList(request));
  }

  public static <T> PageResult buildPageResult(
      Supplier<Integer> countFunction, Supplier<List<T>> listFunction) {
    PageResult result = new PageResult();
    int count = countFunction.get();
    result.setCount(count);
    if (count == 0) {
      return result;
    }
    List<T> dtoList = listFunction.get();
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
