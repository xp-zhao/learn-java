package bean;

import org.smallspring.beans.BeansException;
import org.smallspring.beans.factory.config.BeanPostProcessor;

/** @author zhaoxiaoping @Description: @Date 2021-8-23 */
public class MyBeanPostProcessor implements BeanPostProcessor {

  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    if ("userService".equals(beanName)) {
      UserService userService = (UserService) bean;
      userService.setLocation("改为：location 修改");
    }
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    return bean;
  }
}
