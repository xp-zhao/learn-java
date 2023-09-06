package code.v7;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @author zhaoxiaoping
 * @date 2023-9-6
 */
@Component
public class CheckFactory implements ApplicationContextAware {
  private final Map<CheckEnum, ICheckStrategy> checkStrategyMap = new ConcurrentHashMap<>();

  @Override
  public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
    Map<String, ICheckStrategy> checkMap = applicationContext.getBeansOfType(ICheckStrategy.class);
    checkMap.values().forEach(s -> checkStrategyMap.put(s.getCheckEnum(), s));
  }
  /** 外部调用入口 */
  public void check(CheckEnum checkEnum, String filePathA, String filePathB) throws IOException {
    ICheckStrategy strategy = checkStrategyMap.get(checkEnum);
    strategy.check(filePathA, filePathB);
  }
}
