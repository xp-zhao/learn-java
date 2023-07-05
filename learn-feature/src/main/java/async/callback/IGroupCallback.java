package async.callback;

import java.util.List;

/**
 * @author zhaoxiaoping
 * @date 2023-6-28
 */
public interface IGroupCallback {
  void success(List<?> result);

  void failure(Exception e);
}
