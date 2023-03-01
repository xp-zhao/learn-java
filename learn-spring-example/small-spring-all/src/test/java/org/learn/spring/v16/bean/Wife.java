package org.learn.spring.v16.bean;

/**
 * 测试
 *
 * @author zhaoxiaoping
 * @date 2023-2-28
 */
public class Wife {
  private Husband husband;

  private IMother mother;

  public String queryHusband() {
    return "Wife.husband、Mother.callMother：" + mother.callMother();
  }

  public Husband getHusband() {
    return husband;
  }

  public void setHusband(Husband husband) {
    this.husband = husband;
  }

  public IMother getMother() {
    return mother;
  }

  public void setMother(IMother mother) {
    this.mother = mother;
  }
}
