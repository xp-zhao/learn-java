package parallel.v3.task;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import parallel.v3.UserRequest;
import parallel.v3.dto.BaseDTO;

/**
 * @author zhaoxiaoping
 * @date 2023-9-18
 */
@Component
public class TaskFactory implements ApplicationContextAware {

  private final Map<String, IBaseTask> map = new ConcurrentHashMap<>();

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, IBaseTask> tempMap = applicationContext.getBeansOfType(IBaseTask.class);
    tempMap
        .values()
        .forEach(
            task -> {
              map.put(task.getTaskKey(), task);
            });
  }

  public BaseDTO<Object> executeTask(String key, UserRequest req) {
    IBaseTask task = map.get(key);
    if (task != null) {
      try {
        return task.execute(req);
      } catch (InterruptedException e) {
        throw new RuntimeException(e);
      }
    }
    return null;
  }
}
