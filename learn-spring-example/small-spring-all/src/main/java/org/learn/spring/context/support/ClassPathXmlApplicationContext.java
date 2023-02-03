package org.learn.spring.context.support;

/**
 * xml 应用上下文具体实现类, 负责提供 xml 文件位置
 *
 * @author zhaoxiaoping
 * @date 2023-2-2
 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

  private String[] configLocations;

  public ClassPathXmlApplicationContext() {}

  public ClassPathXmlApplicationContext(String configLocation) {
    this(new String[] {configLocation});
  }

  public ClassPathXmlApplicationContext(String[] configLocations) {
    this.configLocations = configLocations;
    refresh();
  }

  @Override
  protected String[] getConfigLocations() {
    return configLocations;
  }
}
