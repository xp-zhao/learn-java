package common;

import java.util.List;
import lombok.Data;

/**
 * 响应参数
 *
 * @author zhaoxiaoping
 * @date 2024-11-4
 */
@Data
public class PageResponse<T> {
  private Integer pageNum;
  private Integer pageSize;
  private Long total;
  private List<T> data;
}
