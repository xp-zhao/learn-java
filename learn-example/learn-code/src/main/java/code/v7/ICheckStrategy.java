package code.v7;

import java.io.IOException;

/**
 * 数据对比接口
 *
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
public interface ICheckStrategy {
  void check(String filePathA, String filePathB) throws IOException;

  CheckEnum getCheckEnum();
}
