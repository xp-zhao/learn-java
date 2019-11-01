package pattern.visitor;

/**
 * Element.java
 *
 * @author: zhaoxiaoping
 * @date: 2019/11/01
 **/
public abstract class Element {

  public String uuid;

  public Element(String uuid) {
    this.uuid = uuid;
  }

  public abstract void accept(Visitor visitor);
}