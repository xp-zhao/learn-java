package org.litespring.context.support;

import org.litespring.core.io.ClassPathResource;
import org.litespring.core.io.Resource;

/**
 * @author xp-zhao
 * @date 2018/7/9
 */
public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

  public ClassPathXmlApplicationContext(String configFile) {
    super(configFile);
  }

  @Override
  protected Resource getResourceByPath(String path) {
    return new ClassPathResource(path, this.getBeanClassLoader());
  }
}
