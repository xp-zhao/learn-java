package org.smallspring.context.support;

/** @author zhaoxiaoping @Description: @Date 2021-8-23 */
public class ClassPathXmlApplicationContext extends AbstractXmlApplicationContext {

  private String[] configLocations;

  public ClassPathXmlApplicationContext() {}

  public ClassPathXmlApplicationContext(String[] configLocations) {
    this.configLocations = configLocations;
    refresh();
  }

  public ClassPathXmlApplicationContext(String configLocations) {
    this(new String[] {configLocations});
  }

  @Override
  protected String[] getConfigLocations() {
    return configLocations;
  }
}
