package concurrent.transaction;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaoxiaoping
 * @Description:
 * @Date
 **/
public class Allocator {

  private List<Object> als = new ArrayList<>();

  /**
   * 一次性申请所有资源
   */
  synchronized boolean apply(Object from, Object to) {
    if (als.contains(from) || als.contains(to)) {
      return false;
    }
    als.add(from);
    als.add(to);
    return true;
  }

  /**
   * 归还资源
   */
  synchronized void free(Object from, Object to) {
    als.remove(from);
    als.remove(to);
  }
}
